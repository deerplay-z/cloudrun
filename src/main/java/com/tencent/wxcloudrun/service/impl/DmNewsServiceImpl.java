package com.tencent.wxcloudrun.service.impl;


import com.tencent.wxcloudrun.common.core.text.Convert;
import com.tencent.wxcloudrun.domain.DmNews;
import com.tencent.wxcloudrun.mapper.DmNewsMapper;
import com.tencent.wxcloudrun.service.IDmNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 新闻Service业务层处理
 * 
 * @author admin
 * @date 2022-12-19
 */
@Service
public class DmNewsServiceImpl implements IDmNewsService
{
    @Autowired
    private DmNewsMapper dmNewsMapper;

    /**
     * 查询新闻
     * 
     * @param id 新闻ID
     * @return 新闻
     */
    @Override
    public DmNews selectDmNewsById(Integer id)
    {
        return dmNewsMapper.selectDmNewsById(id);
    }

    /**
     * 查询新闻列表
     * 
     * @param dmNews 新闻
     * @return 新闻
     */
    @Override
    public List<DmNews> selectDmNewsList(DmNews dmNews)
    {
        return dmNewsMapper.selectDmNewsList(dmNews);
    }

    @Override
    public List<DmNews> selectHotDmNewsList() {
        return dmNewsMapper.selectHotDmNewsList();
    }

    /**
     * 新增新闻
     * 
     * @param dmNews 新闻
     * @return 结果
     */
    @Override
    public int insertDmNews(DmNews dmNews)
    {
        return dmNewsMapper.insertDmNews(dmNews);
    }

    /**
     * 修改新闻
     * 
     * @param dmNews 新闻
     * @return 结果
     */
    @Override
    public int updateDmNews(DmNews dmNews)
    {
        return dmNewsMapper.updateDmNews(dmNews);
    }

    /**
     * 删除新闻对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDmNewsByIds(String ids)
    {
        return dmNewsMapper.deleteDmNewsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除新闻信息
     * 
     * @param id 新闻ID
     * @return 结果
     */
    @Override
    public int deleteDmNewsById(Integer id)
    {
        return dmNewsMapper.deleteDmNewsById(id);
    }
}
