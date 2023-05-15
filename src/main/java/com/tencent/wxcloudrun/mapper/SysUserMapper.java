package com.tencent.wxcloudrun.mapper;



import com.tencent.wxcloudrun.domain.SysUser;

import java.util.List;

/**
 * 用户Mapper接口
 * 
 * @author admin
 * @date 2022-03-18
 */
public interface SysUserMapper 
{
    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    public SysUser selectSysUserById(Integer id);

    SysUser selectUserByUsername(String username);

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
     * 删除用户
     * 
     * @param id 用户ID
     * @return 结果
     */
    public int deleteSysUserById(Integer id);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUserByIds(String[] ids);
}
