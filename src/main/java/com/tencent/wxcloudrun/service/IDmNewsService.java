package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.domain.DmNews;

import java.util.List;

/**
 * 新闻Service接口
 * 
 * @author admin
 * @date 2022-12-19
 */
public interface IDmNewsService 
{
    /**
     * 查询新闻
     * 
     * @param id 新闻ID
     * @return 新闻
     */
    public DmNews selectDmNewsById(Integer id);

    /**
     * 查询新闻列表
     * 
     * @param dmNews 新闻
     * @return 新闻集合
     */
    public List<DmNews> selectDmNewsList(DmNews dmNews);

    /**
     * 查询热点新闻
     * @return
     */
    List<DmNews> selectHotDmNewsList();

    /**
     * 新增新闻
     * 
     * @param dmNews 新闻
     * @return 结果
     */
    public int insertDmNews(DmNews dmNews);

    /**
     * 修改新闻
     * 
     * @param dmNews 新闻
     * @return 结果
     */
    public int updateDmNews(DmNews dmNews);

    /**
     * 批量删除新闻
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDmNewsByIds(String ids);

    /**
     * 删除新闻信息
     * 
     * @param id 新闻ID
     * @return 结果
     */
    public int deleteDmNewsById(Integer id);
}
