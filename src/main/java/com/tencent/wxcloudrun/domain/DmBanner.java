package com.tencent.wxcloudrun.domain;

import com.tencent.wxcloudrun.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 轮播图对象 dm_banner
 * 
 * @author admin
 * @date 2022-12-19
 */
public class DmBanner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 封面 */
    private String coverImg;

    /** 关联的新闻ID */
    private Integer newsId;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setCoverImg(String coverImg) 
    {
        this.coverImg = coverImg;
    }

    public String getCoverImg() 
    {
        return coverImg;
    }
    public void setNewsId(Integer newsId) 
    {
        this.newsId = newsId;
    }

    public Integer getNewsId() 
    {
        return newsId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("coverImg", getCoverImg())
            .append("newsId", getNewsId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
