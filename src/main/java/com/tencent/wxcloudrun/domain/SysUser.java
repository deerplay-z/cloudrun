package com.tencent.wxcloudrun.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tencent.wxcloudrun.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 用户对象 sys_user
 * 
 * @author admin
 * @date 2022-03-18
 */
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /**  */
    private String username;

    /**  */
    private String password;

    /**  */
    private String truename;

    /**  */
    private String gender;

    /**  */
    private String phone;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**  */
    private String role;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setTruename(String truename) 
    {
        this.truename = truename;
    }

    public String getTruename() 
    {
        return truename;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setRole(String role) 
    {
        this.role = role;
    }

    public String getRole() 
    {
        return role;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("truename", getTruename())
            .append("gender", getGender())
            .append("phone", getPhone())
            .append("birthday", getBirthday())
            .append("role", getRole())
            .toString();
    }
}
