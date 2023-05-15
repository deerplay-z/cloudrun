package com.tencent.wxcloudrun.service.impl;


import com.tencent.wxcloudrun.common.core.text.Convert;
import com.tencent.wxcloudrun.domain.AuthUser;
import com.tencent.wxcloudrun.mapper.AuthUserMapper;
import com.tencent.wxcloudrun.service.IAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthUserServiceImpl implements IAuthUserService {

    @Autowired
    private AuthUserMapper authUserMapper;
    @Override
    public AuthUser selectAuthUserById(Integer id) {
        return authUserMapper.selectAuthUserById(id);
    }

    @Override
    public List<AuthUser> selectAuthUserList(AuthUser authUser) {
        return authUserMapper.selectAuthUserList(authUser);
    }

    @Override
    public int insertAuthUser(AuthUser authUser) {
        return authUserMapper.insertAuthUser(authUser);
    }

    @Override
    public int updateAuthUser(AuthUser authUser) {
        return authUserMapper.updateAuthUser(authUser);
    }

    @Override
    public int deleteAuthUserByIds(String ids) {
        return authUserMapper.deleteAuthUserByIds(Convert.toStrArray(ids));
    }

    @Override
    public int deleteAuthUserById(Integer id) {
        return authUserMapper.deleteAuthUserById(id);
    }
}
