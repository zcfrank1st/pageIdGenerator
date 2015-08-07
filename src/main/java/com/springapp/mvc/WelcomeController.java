package com.springapp.mvc;

import com.springapp.mvc.entity.mybatis.IndexInfo;
import com.springapp.mvc.entity.mybatis.PageInfo;
import com.springapp.mvc.entity.origin.IndexInfoAll;
import com.springapp.mvc.entity.origin.PageIdAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zcfrank1st on 7/7/15.
 */

@Controller
public class WelcomeController {
    @Autowired WelcomeService welcomeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home () {
        return new ModelAndView("redirect:/content/index.html");
    }

    @RequestMapping(value = "/generatepage", method = RequestMethod.POST)
    @ResponseBody
    public String generatePageIdAndSave (@RequestBody PageIdAll pageIdDesc) {
        return "" + welcomeService.generatePageIdAndSave(pageIdDesc);
    }

    @RequestMapping(value = "/getinfos", method = RequestMethod.GET)
    @ResponseBody
    public List<PageInfo> getPageIdInfos () {
        return welcomeService.getPageIdInfos();
    }

    @RequestMapping(value = "/generatemodule", method = RequestMethod.POST)
    @ResponseBody
    public void saveInfos (@RequestBody IndexInfoAll indexInfoDesc) {
        welcomeService.generateModuleAndSave(indexInfoDesc);
    }

    @RequestMapping(value = "/pages/{departmentId}", method = RequestMethod.GET)
    @ResponseBody
    public List<PageInfo> showPages (@PathVariable int departmentId) {
        return welcomeService.showPages(departmentId);
    }

    @RequestMapping(value = "/modules/{departmentId}/{pageId}", method = RequestMethod.GET)
    @ResponseBody
    public List<IndexInfo> showModules (@PathVariable int departmentId, @PathVariable int pageId) {
        return welcomeService.showModules(departmentId, pageId);
    }

    @RequestMapping(value = "/page/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePage(@PathVariable int id) {
        welcomeService.delPage(id);
    }

    @RequestMapping(value = "/module/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteModule(@PathVariable int id) {
        welcomeService.delModule(id);
    }

    @RequestMapping(value = "/update/page", method = RequestMethod.POST)
    @ResponseBody
    public void updatePage (@RequestBody PageIdAll pageIdDesc) {
        welcomeService.updatePage(pageIdDesc);
    }

    @RequestMapping(value = "/update/module", method = RequestMethod.POST)
    @ResponseBody
    public void generatePageIdAndSave (@RequestBody IndexInfoAll indexInfoAll) {
        welcomeService.updateModule(indexInfoAll);
    }

    @RequestMapping(value = "/pages", method = RequestMethod.GET)
    @ResponseBody
    public List<PageInfo> showAllPages () {
        return welcomeService.showAllPages();
    }

    @RequestMapping(value = "/modules", method = RequestMethod.GET)
    @ResponseBody
    public List<IndexInfo> showAllModules () {
        return welcomeService.showAllModules();
    }
}
