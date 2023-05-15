package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.common.core.controller.BaseController;
import com.tencent.wxcloudrun.common.core.domain.AjaxResult;
import com.tencent.wxcloudrun.common.core.page.TableDataInfo;
import com.tencent.wxcloudrun.domain.SysUser;
import com.tencent.wxcloudrun.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户Controller
 * 
 * @author admin
 * @date 2022-03-18
 */
@Controller
@RequestMapping("/dm/user")
public class SysUserController extends BaseController
{
    private String prefix = "dm/user";

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询用户列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUser sysUser)
    {
        startPage();
        List<SysUser> list = sysUserService.selectSysUserList(sysUser);
        return getDataTable(list);
    }


    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysUser sysUser)
    {
        SysUser entity = sysUserService.selectUserByUsername(sysUser.getUsername());
        if(entity != null){
            return AjaxResult.error("用户名已存在！");
        }

        return toAjax(sysUserService.insertSysUser(sysUser));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        SysUser sysUser = sysUserService.selectSysUserById(id);
        mmap.put("sysUser", sysUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysUser sysUser)
    {
        return toAjax(sysUserService.updateSysUser(sysUser));
    }

    /**
     * 删除用户
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysUserService.deleteSysUserByIds(ids));
    }
}
