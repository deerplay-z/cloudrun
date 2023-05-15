package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.common.core.controller.BaseController;
import com.tencent.wxcloudrun.common.core.domain.AjaxResult;
import com.tencent.wxcloudrun.common.core.page.TableDataInfo;
import com.tencent.wxcloudrun.common.utils.StringUtils;
import com.tencent.wxcloudrun.domain.*;
import com.tencent.wxcloudrun.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/openapi")
public class OpenApi extends BaseController {

    @Autowired
    ISysUserService userService;

    @Autowired
    IDmNewsService dmNewsService;

    @Autowired
    IDmBannerService bannerService;


    @PostMapping("/doLogin")
    public AjaxResult login(@RequestBody LoginForm loginForm){
        SysUser entity = userService.selectUserByUsername(loginForm.getUsername());
        String err = "";
        // 未找到用户
        if(entity == null){
            err = "用户不存在！";
        }else if(!loginForm.getPassword().equals(entity.getPassword())){
            err = "密码错误！";
        }

        if(StringUtils.isNotEmpty(err)){
            return AjaxResult.error(err);
        }

        return AjaxResult.success(entity);
    }

    /**
     * 查询资讯列表，支持根据新闻类型查找
     */
    @PostMapping("/dmNews/list")
    public AjaxResult listDmNews(@RequestBody DmNews news)
    {
        //startPage();
        List<DmNews> list = dmNewsService.selectDmNewsList(news);
        return AjaxResult.success(list);
    }

    /**
     *  获取热点新闻，根据阅读数+点赞数降序取top10
     * @return
     */
    @GetMapping("/dmNews/hotlist")
    public AjaxResult getHotDmNews(){
        List<DmNews> list = dmNewsService.selectHotDmNewsList();
        return AjaxResult.success(list);
    }


    @GetMapping("/dmNews/{id}")
    public AjaxResult getById(@PathVariable("id") Integer id){
        // 阅读数+1
        DmNews dmNews = dmNewsService.selectDmNewsById(id);
        dmNews.setReadCount(dmNews.getReadCount()+1);
        dmNewsService.updateDmNews(dmNews);

        return AjaxResult.success(dmNews);
    }

    @GetMapping("/dmNews/addLikeCount/{id}")
    public AjaxResult like(@PathVariable("id") Integer id){
        // 阅读数+1
        DmNews dmNews = dmNewsService.selectDmNewsById(id);
        dmNews.setLikeCount(dmNews.getLikeCount()+1);
        dmNewsService.updateDmNews(dmNews);

        return AjaxResult.success();
    }
    /**
     * 查询轮播图列表
     */
    @GetMapping("/dmBanner/list")
    public TableDataInfo listDmBanner()
    {
        startPage();
        List<DmBanner> list = bannerService.selectDmBannerList(null);
        return getDataTable(list);
    }

    /**
     *  修改密码
     * @param param
     * @return
     */
    @PostMapping("/modifyPassword")
    @ResponseBody
    public AjaxResult modifyPassword(@RequestBody PasswordForm param){
        // 从session中获取当前登录用户
        String oldPassword = param.getPassword();
        String newPassword = param.getNewpassword();
        String newPassword2 = param.getNewpassword2();

        if(StringUtils.isEmpty(oldPassword)){
            return AjaxResult.error("原密码不能为空！");
        }

        if(StringUtils.isEmpty(newPassword)){
            return AjaxResult.error("新密码不能为空！");
        }

        if(StringUtils.isEmpty(newPassword2)){
            return AjaxResult.error("确认密码不能为空！");
        }

        if(oldPassword.equals(newPassword)){
            return AjaxResult.error("新密码不能和旧密码一致！");
        }

        if(newPassword.length() > 10 || newPassword.length() < 3){
            return AjaxResult.error("新密码长度必须为3-10之间！");
        }

        // 根据用户名查询用户
        SysUser user = userService.selectUserByUsername(param.getUsername());
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
