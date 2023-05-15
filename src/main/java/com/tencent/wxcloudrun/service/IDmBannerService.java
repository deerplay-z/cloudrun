package com.tencent.wxcloudrun.service;


import com.tencent.wxcloudrun.domain.DmBanner;

import java.util.List;

/**
 * 轮播图Service接口
 * 
 * @author admin
 * @date 2022-12-19
 */
public interface IDmBannerService 
{
    /**
     * 查询轮播图
     * 
     * @param id 轮播图ID
     * @return 轮播图
     */
    public DmBanner selectDmBannerById(Integer id);

    /**
     * 查询轮播图列表
     * 
     * @param dmBanner 轮播图
     * @return 轮播图集合
     */
    public List<DmBanner> selectDmBannerList(DmBanner dmBanner);

    /**
     * 新增轮播图
     * 
     * @param dmBanner 轮播图
     * @return 结果
     */
    public int insertDmBanner(DmBanner dmBanner);

    /**·
     * 修改轮播图
     * 
     * @param dmBanner 轮播图
     * @return 结果
     */
    public int updateDmBanner(DmBanner dmBanner);

    /**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDmBannerByIds(String ids);

    /**
     * 删除轮播图信息
     * 
     * @param id 轮播图ID
     * @return 结果
     */
    public int deleteDmBannerById(Integer id);
}
