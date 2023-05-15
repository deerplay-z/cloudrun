package com.tencent.wxcloudrun.common.exception.user;


import com.tencent.wxcloudrun.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author app
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
