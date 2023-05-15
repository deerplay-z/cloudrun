package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.common.core.controller.BaseController;
import com.tencent.wxcloudrun.common.core.domain.AjaxResult;
import com.tencent.wxcloudrun.common.core.page.TableDataInfo;
import com.tencent.wxcloudrun.domain.DmNews;
import com.tencent.wxcloudrun.service.IDmNewsService;
import com.tencent.wxcloudrun.service.IDmNewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 新闻Controller
 * 
 * @author admin
 * @date 2022-12-19
 */
@Controller
@RequestMapping("/dm/news")
public class DmNewsController extends BaseController
{
    private String prefix = "dm/news";

    @Autowired
    private IDmNewsService dmNewsService;

    @Autowired
    IDmNewsTypeService newsTypeService;

    @GetMapping()
    public String news()
    {
        return prefix + "/news";
    }

    /**
     * 查询新闻列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DmNews dmNews)
    {
        startPage();
        List<DmNews> list = dmNewsService.selectDmNewsList(dmNews);
        return getDataTable(list);
    }


    /**
     * 新增新闻
     */
    @GetMapping("/add")
    public String add(ModelMap map)
    {
        // 新闻分类列表
        map.put("newsTypeList",newsTypeService.selectDmNewsTypeList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存新闻
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DmNews dmNews)
    {
        return toAjax(dmNewsService.insertDmNews(dmNews));
    }

    /**
     * 修改新闻
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        DmNews dmNews = dmNewsService.selectDmNewsById(id);
        mmap.put("dmNews", dmNews);
        // 新闻分类列表
        mmap.put("newsTypeList",newsTypeService.selectDmNewsTypeList(null));
        return prefix + "/edit";
    }

    /**
     * 修改保存新闻
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DmNews dmNews)
    {
        return toAjax(dmNewsService.updateDmNews(dmNews));
    }

    /**
     * 删除新闻
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dmNewsService.deleteDmNewsByIds(ids));
    }
}
