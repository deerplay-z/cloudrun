package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.domain.DmNewsType;

import java.util.List;

/**
 * 新闻分类Service接口
 * 
 * @author admin
 * @date 2022-12-19
 */
public interface IDmNewsTypeService 
{
    /**
     * 查询新闻分类
     * 
     * @param id 新闻分类ID
     * @return 新闻分类
     */
    public DmNewsType selectDmNewsTypeById(Integer id);

    /**
     * 查询新闻分类列表
     * 
     * @param dmNewsType 新闻分类
     * @return 新闻分类集合
     */
    public List<DmNewsType> selectDmNewsTypeList(DmNewsType dmNewsType);

    /**
     * 新增新闻分类
     * 
     * @param dmNewsType 新闻分类
     * @return 结果
     */
    public int insertDmNewsType(DmNewsType dmNewsType);

    /**
     * 修改新闻分类
     * 
     * @param dmNewsType 新闻分类
     * @return 结果
     */
    public int updateDmNewsType(DmNewsType dmNewsType);

    /**
     * 批量删除新闻分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDmNewsTypeByIds(String ids);

    /**
     * 删除新闻分类信息
     * 
     * @param id 新闻分类ID
     * @return 结果
     */
    public int deleteDmNewsTypeById(Integer id);
}
