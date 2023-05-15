package com.tencent.wxcloudrun.service.impl;


import com.tencent.wxcloudrun.common.core.text.Convert;
import com.tencent.wxcloudrun.domain.SysUser;
import com.tencent.wxcloudrun.mapper.SysUserMapper;
import com.tencent.wxcloudrun.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service业务层处理
 * 
 * @author admin
 * @date 2022-03-18
 */
@Service
public class SysUserServiceImpl implements ISysUserService
{
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public SysUser selectSysUserById(Integer id)
    {
        return sysUserMapper.selectSysUserById(id);
    }


    @Override
    public SysUser selectUserByUsername(String username) {
        return sysUserMapper.selectUserByUsername(username);
    }
    /**
     * 查询用户列表
     * 
     * @param sysUser 用户
     * @return 用户
     */
    @Override
    public List<SysUser> selectSysUserList(SysUser sysUser)
    {
        return sysUserMapper.selectSysUserList(sysUser);
    }

    /**
     * 新增用户
     * 
     * @param sysUser 用户
     * @return 结果
     */
    @Override
    public int insertSysUser(SysUser sysUser)
    {

        return sysUserMapper.insertSysUser(sysUser);
    }

    /**
     * 修改用户
     * 
     * @param sysUser 用户
     * @return 结果
     */
    @Override
    public int updateSysUser(SysUser sysUser)
    {
        return sysUserMapper.updateSysUser(sysUser);
    }

    /**
     * 删除用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysUserByIds(String ids)
    {
        return sysUserMapper.deleteSysUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户信息
     * 
     * @param id 用户ID
     * @return 结果
     */
    @Override
    public int deleteSysUserById(Integer id)
    {
        return sysUserMapper.deleteSysUserById(id);
    }
}
