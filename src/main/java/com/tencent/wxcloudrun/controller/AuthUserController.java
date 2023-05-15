package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.common.core.controller.BaseController;
import com.tencent.wxcloudrun.common.core.domain.AjaxResult;
import com.tencent.wxcloudrun.common.core.page.TableDataInfo;
import com.tencent.wxcloudrun.domain.AuthUser;
import com.tencent.wxcloudrun.service.IAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dm/authUser")
public class AuthUserController  extends BaseController {
    private String prefix = "dm/authUser";

    @Autowired
    private IAuthUserService authUserService;

    @GetMapping
    public String authuser(){
        return prefix +"/authuser";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AuthUser authUser)
    {
        startPage();
        List<AuthUser> list = authUserService.selectAuthUserList(authUser);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix +"/add";
    }

    /**
     * 新增保存轮播图
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AuthUser authUser)
    {
        return toAjax(authUserService.insertAuthUser(authUser));
    }

    /**
     * 修改轮播图
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        AuthUser authUser = authUserService.selectAuthUserById(id);
        mmap.put("authUser", authUser);
        return prefix + "/edit";
    }


}
