package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.common.core.controller.BaseController;
import com.tencent.wxcloudrun.common.core.domain.AjaxResult;
import com.tencent.wxcloudrun.common.core.page.TableDataInfo;
import com.tencent.wxcloudrun.domain.DmNewsType;
import com.tencent.wxcloudrun.service.IDmNewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 新闻分类Controller
 * 
 * @author admin
 * @date 2022-12-19
 */
@Controller
@RequestMapping("/dm/newsType")
public class DmNewsTypeController extends BaseController
{
    private String prefix = "dm/newsType";

    @Autowired
    private IDmNewsTypeService dmNewsTypeService;

    @GetMapping()
    public String type()
    {
        return prefix + "/newsType";
    }

    /**
     * 查询新闻分类列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DmNewsType dmNewsType)
    {
        startPage();
        List<DmNewsType> list = dmNewsTypeService.selectDmNewsTypeList(dmNewsType);
        return getDataTable(list);
    }


    /**
     * 新增新闻分类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存新闻分类
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DmNewsType dmNewsType)
    {
        return toAjax(dmNewsTypeService.insertDmNewsType(dmNewsType));
    }

    /**
     * 修改新闻分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        DmNewsType dmNewsType = dmNewsTypeService.selectDmNewsTypeById(id);
        mmap.put("dmNewsType", dmNewsType);
        return prefix + "/edit";
    }

    /**
     * 修改保存新闻分类
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DmNewsType dmNewsType)
    {
        return toAjax(dmNewsTypeService.updateDmNewsType(dmNewsType));
    }

    /**
     * 删除新闻分类
     */
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dmNewsTypeService.deleteDmNewsTypeByIds(ids));
    }
}
