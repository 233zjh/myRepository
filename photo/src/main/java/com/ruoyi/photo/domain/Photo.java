package com.ruoyi.photo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图片视频资源对象 photo
 * 
 * @author ruoyi
 * @date 2023-04-11
 */
public class Photo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片id */
    private Long id;

    /** 类型：1图片2视频 */
    @Excel(name = "类型：1图片2视频")
    private Long type;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 资源地址 */
    @Excel(name = "资源地址")
    private String sourceUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSourceUrl(String sourceUrl) 
    {
        this.sourceUrl = sourceUrl;
    }

    public String getSourceUrl() 
    {
        return sourceUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("name", getName())
            .append("sourceUrl", getSourceUrl())
            .toString();
    }
}
