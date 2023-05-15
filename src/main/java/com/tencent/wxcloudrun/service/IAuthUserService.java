package com.tencent.wxcloudrun.service;



import com.tencent.wxcloudrun.domain.AuthUser;

import java.util.List;

public interface IAuthUserService {
    /**
     * 查询轮播图
     *
     * @param id 轮播图ID
     * @return 轮播图
     */
    public AuthUser selectAuthUserById(Integer id);

    /**
     * 查询轮播图列表
     *
     * @param dmBanner 轮播图
     * @return 轮播图集合
     */
    public List<AuthUser> selectAuthUserList(AuthUser authUser);

    /**
     * 新增轮播图
     *
     * @param dmBanner 轮播图
     * @return 结果
     */
    public int insertAuthUser(AuthUser authUser);

    /**
     * 修改轮播图
     *
     * @param dmBanner 轮播图
     * @return 结果
     */
    public int updateAuthUser(AuthUser authUser);

    /**
     * 批量删除轮播图
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAuthUserByIds(String ids);

    /**
     * 删除轮播图信息
     *
     * @param id 轮播图ID
     * @return 结果
     */
    public int deleteAuthUserById(Integer id);
}
