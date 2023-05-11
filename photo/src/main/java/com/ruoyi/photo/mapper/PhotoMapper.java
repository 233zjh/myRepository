package com.ruoyi.photo.mapper;

import java.util.List;
import com.ruoyi.photo.domain.Photo;

/**
 * 图片视频资源Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
public interface PhotoMapper 
{
    /**
     * 查询图片视频资源
     * 
     * @param id 图片视频资源主键
     * @return 图片视频资源
     */
    public Photo selectPhotoById(Long id);

    /**
     * 查询图片视频资源列表
     * 
     * @param photo 图片视频资源
     * @return 图片视频资源集合
     */
    public List<Photo> selectPhotoList(Photo photo);

    /**
     * 新增图片视频资源
     * 
     * @param photo 图片视频资源
     * @return 结果
     */
    public int insertPhoto(Photo photo);

    /**
     * 修改图片视频资源
     * 
     * @param photo 图片视频资源
     * @return 结果
     */
    public int updatePhoto(Photo photo);

    /**
     * 删除图片视频资源
     * 
     * @param id 图片视频资源主键
     * @return 结果
     */
    public int deletePhotoById(Long id);

    /**
     * 批量删除图片视频资源
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePhotoByIds(Long[] ids);
}
