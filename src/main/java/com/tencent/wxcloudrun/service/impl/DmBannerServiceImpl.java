package com.tencent.wxcloudrun.service.impl;


import com.tencent.wxcloudrun.common.core.text.Convert;
import com.tencent.wxcloudrun.common.utils.DateUtils;
import com.tencent.wxcloudrun.domain.DmBanner;
import com.tencent.wxcloudrun.mapper.DmBannerMapper;
import com.tencent.wxcloudrun.service.IDmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 轮播图Service业务层处理
 * 
 * @author admin
 * @date 2022-12-19
 */
@Service
public class DmBannerServiceImpl implements IDmBannerService
{
    @Autowired
    private DmBannerMapper dmBannerMapper;

    /**
     * 查询轮播图
     * 
     * @param id 轮播图ID
     * @return 轮播图
     */
    @Override
    public DmBanner selectDmBannerById(Integer id)
    {
        return dmBannerMapper.selectDmBannerById(id);
    }

    /**
     * 查询轮播图列表
     * 
     * @param dmBanner 轮播图
     * @return 轮播图
     */
    @Override
    public List<DmBanner> selectDmBannerList(DmBanner dmBanner)
    {
        return dmBannerMapper.selectDmBannerList(dmBanner);
    }

    /**
     * 新增轮播图
     * 
     * @param dmBanner 轮播图
     * @return 结果
     */
    @Override
    public int insertDmBanner(DmBanner dmBanner)
    {
        dmBanner.setCreateTime(DateUtils.getNowDate());
        return dmBannerMapper.insertDmBanner(dmBanner);
    }

    /**
     * 修改轮播图
     * 
     * @param dmBanner 轮播图
     * @return 结果
     */
    @Override
    public int updateDmBanner(DmBanner dmBanner)
    {
        return dmBannerMapper.updateDmBanner(dmBanner);
    }

    /**
     * 删除轮播图对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDmBannerByIds(String ids)
    {
        return dmBannerMapper.deleteDmBannerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除轮播图信息
     * 
     * @param id 轮播图ID
     * @return 结果
     */
    @Override
    public int deleteDmBannerById(Integer id)
    {
        return dmBannerMapper.deleteDmBannerById(id);
    }
}
