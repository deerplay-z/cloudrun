package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.common.core.domain.AjaxResult;
import com.tencent.wxcloudrun.domain.SysUser;
import com.tencent.wxcloudrun.service.ISysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Description: 用户控制器
 * @Author admin
 * @Date 2021-12-28
 **/
@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired
    ISysUserService userService;

    @PostMapping("doLogin")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpServletRequest request, HttpServletResponse response){
        SysUser entity = userService.selectUserByUsername(username);

        // 未找到用户
        if(entity == null){
            model.addAttribute("error","用户不存在！");
            return "login";
        }

        if(!password.equals(entity.getPassword())){
            model.addAttribute("error","密码错误！");
            return "login";
        }

        if(!"admin".equals(entity.getRole())){
            model.addAttribute("error","请使用管理员账号登录！");
            return "login";
        }

        model.addAttribute("username",username);
        request.getSession().setAttribute("username",username);

        return "redirect:/index";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("username");
        return "login";
    }

    /**
     *  修改密码
     * @param param
     * @return
     */
    @PostMapping("modifyPassword")
    @ResponseBody
    public AjaxResult bookEdit(@RequestBody Map<String,String> param, HttpServletRequest request){
        // 从session中获取当前登录用户
        String username = (String) request.getSession().getAttribute("username");
        String oldPassword = param.get("oldPassword");
        String newPassword = param.get("newPassword");
        String newPassword2 = param.get("newPassword2");

        if(StringUtils.isEmpty(oldPassword)){
            return AjaxResult.error("原密码不能为空！");
        }

        if(StringUtils.isEmpty(newPassword)){
            return AjaxResult.error("新密码不能为空！");
        }

        if(StringUtils.isEmpty(newPassword2)){
            return AjaxResult.error("确认密码不能为空！");
        }
        // 根据用户名查询用户
        SysUser user = userService.selectUserByUsername(username);
        String realPassword = user.getPassword();
        if(!(oldPassword.equals(realPassword))){
            return AjaxResult.error("原密码输入错误！");
        }

        if(!(newPassword.equals(newPassword2))){
            return AjaxResult.error("新密码输入不一致！");
        }

        user.setPassword(newPassword);

        userService.updateSysUser(user);

        return AjaxResult.success();
    }


}
