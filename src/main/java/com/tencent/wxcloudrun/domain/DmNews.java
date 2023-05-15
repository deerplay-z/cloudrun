package com.tencent.wxcloudrun.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tencent.wxcloudrun.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 新闻对象 dm_news
 * 
 * @author admin
 * @date 2022-12-19
 */
public class DmNews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 标题 */
    private String title;

    /** 封面 */
    private String coverImg;

    /** 内容 */
    private String content;

    /** 点赞数 */
    private Integer likeCount;

    /** 阅读数 */
    private Integer readCount;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date addTime;

    /** 新闻分类ID */
    private Integer newsTypeId;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setCoverImg(String coverImg) 
    {
        this.coverImg = coverImg;
    }

    public String getCoverImg() 
    {
        return coverImg;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setLikeCount(Integer likeCount) 
    {
        this.likeCount = likeCount;
    }

    public Integer getLikeCount() 
    {
        return likeCount;
    }
    public void setReadCount(Integer readCount) 
    {
        this.readCount = readCount;
    }

    public Integer getReadCount() 
    {
        return readCount;
    }
    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }
    public void setNewsTypeId(Integer newsTypeId)
    {
        this.newsTypeId = newsTypeId;
    }

    public Integer getNewsTypeId()
    {
        return newsTypeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("coverImg", getCoverImg())
            .append("content", getContent())
            .append("likeCount", getLikeCount())
            .append("readCount", getReadCount())
            .append("addTime", getAddTime())
            .append("newsTypeId", getNewsTypeId())
            .toString();
    }
}
