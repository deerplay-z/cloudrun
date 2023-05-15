package com.tencent.wxcloudrun.mapper;



import com.tencent.wxcloudrun.domain.AuthUser;

import java.util.List;

public interface AuthUserMapper {

    /**
     * 查询轮播图
     *
     * @param id 鉴权用户id
     * @return 轮播图
     */
    public AuthUser selectAuthUserById(Integer id);

    /**
     * 查询鉴权的用户
     *
     * @param authUser 轮播图
     * @return 轮播图集合
     */
    public List<AuthUser> selectAuthUserList(AuthUser authUser);

    /**
     * 新增鉴权用户
     *
     * @param authUser 轮播图
     * @return 结果
     */
    public int insertAuthUser(AuthUser authUser);

    /**
     * 修改轮播图
     *
     * @param authUser 轮播图
     * @return 结果
     */
    public int updateAuthUser(AuthUser authUser);

    /**
     * 删除轮播图
     *
     * @param id 轮播图ID
     * @return 结果
     */
    public int deleteAuthUserById(Integer id);

    /**
     * 批量删除轮播图
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAuthUserByIds(String[] ids);
}
