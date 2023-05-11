package com.ruoyi.photo.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.StringUtils;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.apache.commons.io.FileUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.photo.domain.Photo;
import com.ruoyi.photo.service.IPhotoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片视频资源Controller
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
@RestController
@RequestMapping("/photo/photo")
public class PhotoController extends BaseController
{
    @Autowired
    private IPhotoService photoService;

    /**
     * 查询图片视频资源列表
     */
    @PreAuthorize("@ss.hasPermi('photo:photo:list')")
    @GetMapping("/list")
    public TableDataInfo list(Photo photo)
    {
        startPage();
        List<Photo> list = photoService.selectPhotoList(photo);
        return getDataTable(list);
    }

    /**
     * 导出图片视频资源列表
     */
    @PreAuthorize("@ss.hasPermi('photo:photo:export')")
    @Log(title = "图片视频资源", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Photo photo)
    {
        List<Photo> list = photoService.selectPhotoList(photo);
        ExcelUtil<Photo> util = new ExcelUtil<Photo>(Photo.class);
        util.exportExcel(response, list, "图片视频资源数据");
    }

    /**
     * 获取图片视频资源详细信息
     */
    @PreAuthorize("@ss.hasPermi('photo:photo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(photoService.selectPhotoById(id));
    }

    /**
     * 新增图片视频资源
     */
    @PreAuthorize("@ss.hasPermi('photo:photo:add')")
    @Log(title = "图片视频资源", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Photo photo) throws IOException {
        int num = photoService.insertPhoto(photo);
        if(num!=0){
            String path = RuoYiConfig.getProfile();
            File file = new File(path,"data.json");
            if(!file.exists()){
                file.createNewFile();
            }
            JSONArray array;
            String str = FileUtils.readFileToString(file,"utf-8");
            if(StringUtils.isEmpty(str)){
                array = new JSONArray();
            }else{
                array = JSONArray.parseArray(str);
            }
            System.out.println(array.toString());
            if(!StringUtils.isEmpty(photo.getSourceUrl())){
                JSONObject json = new JSONObject();
                json.put("name",photo.getName());
                json.put("url", photo.getSourceUrl().replace("/profile",""));
                array.add(json);
            }
            FileUtils.writeStringToFile(file,array.toString(),"utf-8");
        }
        return toAjax(num);
    }

    /**
     * 修改图片视频资源
     */
    @PreAuthorize("@ss.hasPermi('photo:photo:edit')")
    @Log(title = "图片视频资源", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Photo photo)
    {
        return toAjax(photoService.updatePhoto(photo));
    }

    /**
     * 删除图片视频资源
     */
    @PreAuthorize("@ss.hasPermi('photo:photo:remove')")
    @Log(title = "图片视频资源", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(photoService.deletePhotoByIds(ids));
    }
}
