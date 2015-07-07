package com.springapp.mvc;

import com.springapp.mvc.entity.mybatis.PageInfo;
import com.springapp.mvc.entity.origin.IndexInfoAll;
import com.springapp.mvc.entity.origin.PageIdAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/generatepageid", method = RequestMethod.POST)
    @ResponseBody
    public void generatePageIdAndSave (@RequestBody PageIdAll pageIdDesc) {
        welcomeService.generatePageIdAndSave(pageIdDesc);
    }

    @RequestMapping(value = "/getinfos", method = RequestMethod.GET)
    @ResponseBody
    public List<PageInfo> getPageIdInfos () {
        return welcomeService.getPageIdInfos();
    }

    @RequestMapping(value = "/saveinfos", method = RequestMethod.POST)
    @ResponseBody
    public void saveInfos (@RequestBody IndexInfoAll indexInfoDesc) {
        welcomeService.saveInfos(indexInfoDesc);
    }
}
