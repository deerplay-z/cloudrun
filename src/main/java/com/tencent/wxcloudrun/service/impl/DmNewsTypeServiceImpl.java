package com.tencent.wxcloudrun.service.impl;


import com.tencent.wxcloudrun.common.core.text.Convert;
import com.tencent.wxcloudrun.common.utils.DateUtils;
import com.tencent.wxcloudrun.domain.DmNewsType;
import com.tencent.wxcloudrun.mapper.DmNewsTypeMapper;
import com.tencent.wxcloudrun.service.IDmNewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 新闻分类Service业务层处理
 * 
 * @author admin
 * @date 2022-12-19
 */
@Service
public class DmNewsTypeServiceImpl implements IDmNewsTypeService
{
    @Autowired
    private DmNewsTypeMapper dmNewsTypeMapper;

    /**
     * 查询新闻分类
     * 
     * @param id 新闻分类ID
     * @return 新闻分类
     */
    @Override
    public DmNewsType selectDmNewsTypeById(Integer id)
    {
        return dmNewsTypeMapper.selectDmNewsTypeById(id);
    }

    /**
     * 查询新闻分类列表
     * 
     * @param dmNewsType 新闻分类
     * @return 新闻分类
     */
    @Override
    public List<DmNewsType> selectDmNewsTypeList(DmNewsType dmNewsType)
    {
        return dmNewsTypeMapper.selectDmNewsTypeList(dmNewsType);
    }

    /**
     * 新增新闻分类
     * 
     * @param dmNewsType 新闻分类
     * @return 结果
     */
    @Override
    public int insertDmNewsType(DmNewsType dmNewsType)
    {
        dmNewsType.setCreateTime(DateUtils.getNowDate());
        return dmNewsTypeMapper.insertDmNewsType(dmNewsType);
    }

    /**
     * 修改新闻分类
     * 
     * @param dmNewsType 新闻分类
     * @return 结果
     */
    @Override
    public int updateDmNewsType(DmNewsType dmNewsType)
    {
        return dmNewsTypeMapper.updateDmNewsType(dmNewsType);
    }

    /**
     * 删除新闻分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDmNewsTypeByIds(String ids)
    {
        return dmNewsTypeMapper.deleteDmNewsTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除新闻分类信息
     * 
     * @param id 新闻分类ID
     * @return 结果
     */
    @Override
    public int deleteDmNewsTypeById(Integer id)
    {
        return dmNewsTypeMapper.deleteDmNewsTypeById(id);
    }
}
