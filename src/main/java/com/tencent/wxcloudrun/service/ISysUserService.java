package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.domain.SysUser;

import java.util.List;

/**
 * 用户Service接口
 * 
 * @author admin
 * @date 2022-03-18
 */
public interface ISysUserService 
{
    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    public SysUser selectSysUserById(Integer id);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public SysUser selectUserByUsername(String username);

    /**
     * 查询用户列表
     * 
     * @param sysUser 用户
     * @return 用户集合
     */
    public List<SysUser> selectSysUserList(SysUser sysUser);

    /**
     * 新增用户
     * 
     * @param sysUser 用户
     * @return 结果
     */
    public int insertSysUser(SysUser sysUser);

    /**
     * 修改用户
     * 
     * @param sysUser 用户
     * @return 结果
     */
    public int updateSysUser(SysUser sysUser);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUserByIds(String ids);

    /**
     * 删除用户信息
     * 
     * @param id 用户ID
     * @return 结果
     */
    public int deleteSysUserById(Integer id);
}
