package com.tencent.wxcloudrun.domain;

import lombok.Data;

@Data
public class PasswordForm {
    private String username; // 用户名
    private String password; // 旧密码
    private String newpassword; // 新密码
    private String newpassword2; // 确认密码
}
