package com.ruoyi.photo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.photo.mapper.PhotoMapper;
import com.ruoyi.photo.domain.Photo;
import com.ruoyi.photo.service.IPhotoService;

/**
 * 图片视频资源Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
@Service
public class PhotoServiceImpl implements IPhotoService 
{
    @Autowired
    private PhotoMapper photoMapper;

    /**
     * 查询图片视频资源
     * 
     * @param id 图片视频资源主键
     * @return 图片视频资源
     */
    @Override
    public Photo selectPhotoById(Long id)
    {
        return photoMapper.selectPhotoById(id);
    }

    /**
     * 查询图片视频资源列表
     * 
     * @param photo 图片视频资源
     * @return 图片视频资源
     */
    @Override
    public List<Photo> selectPhotoList(Photo photo)
    {
        return photoMapper.selectPhotoList(photo);
    }

    /**
     * 新增图片视频资源
     * 
     * @param photo 图片视频资源
     * @return 结果
     */
    @Override
    public int insertPhoto(Photo photo)
    {
        return photoMapper.insertPhoto(photo);
    }

    /**
     * 修改图片视频资源
     * 
     * @param photo 图片视频资源
     * @return 结果
     */
    @Override
    public int updatePhoto(Photo photo)
    {
        return photoMapper.updatePhoto(photo);
    }

    /**
     * 批量删除图片视频资源
     * 
     * @param ids 需要删除的图片视频资源主键
     * @return 结果
     */
    @Override
    public int deletePhotoByIds(Long[] ids)
    {
        return photoMapper.deletePhotoByIds(ids);
    }

    /**
     * 删除图片视频资源信息
     * 
     * @param id 图片视频资源主键
     * @return 结果
     */
    @Override
    public int deletePhotoById(Long id)
    {
        return photoMapper.deletePhotoById(id);
    }
}
