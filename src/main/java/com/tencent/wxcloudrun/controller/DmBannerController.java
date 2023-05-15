package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.common.core.controller.BaseController;
import com.tencent.wxcloudrun.common.core.domain.AjaxResult;
import com.tencent.wxcloudrun.common.core.page.TableDataInfo;
import com.tencent.wxcloudrun.domain.DmBanner;
import com.tencent.wxcloudrun.service.IDmBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 轮播图Controller
 * 
 * @author admin
 * @date 2022-12-19
 */
@Controller
@RequestMapping("/dm/banner")
public class DmBannerController extends BaseController
{
    private String prefix = "dm/banner";

    @Autowired
    private IDmBannerService dmBannerService;

    @GetMapping()
    public String banner()
    {
        return prefix + "/banner";
    }

    /**
     * 查询轮播图列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DmBanner dmBanner)
    {
        startPage();
        List<DmBanner> list = dmBannerService.selectDmBannerList(dmBanner);
        return getDataTable(list);
    }


    /**
     * 新增轮播图
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存轮播图
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DmBanner dmBanner)
    {
        return toAjax(dmBannerService.insertDmBanner(dmBanner));
    }

    /**
     * 修改轮播图
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        DmBanner dmBanner = dmBannerService.selectDmBannerById(id);
        mmap.put("dmBanner", dmBanner);
        return prefix + "/edit";
    }

    /**
     * 修改保存轮播图
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DmBanner dmBanner)
    {
        return toAjax(dmBannerService.updateDmBanner(dmBanner));
    }

    /**
     * 删除轮播图
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dmBannerService.deleteDmBannerByIds(ids));
    }
}
