package com.springapp.mvc;

import com.springapp.mvc.entity.mybatis.IndexInfo;
import com.springapp.mvc.entity.mybatis.PageInfo;
import com.springapp.mvc.entity.origin.IndexInfoAll;
import com.springapp.mvc.entity.origin.PageIdAll;
import com.springapp.mvc.mappers.IndexInfoMapper;
import com.springapp.mvc.mappers.PageInfoMapper;
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
    @Autowired
    private IndexInfoMapper indexInfoMapper;
    @Autowired
    private PageInfoMapper pageInfoMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home () {
        return new ModelAndView("redirect:/content/index.html");
    }

    @RequestMapping(value = "/generatepageid", method = RequestMethod.POST)
    @ResponseBody
    public void generatePageIdAndSave (@RequestBody PageIdAll pageIdDesc) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageName(pageIdDesc.getPageIdName());
        pageInfo.setDescription(pageIdDesc.getPageIdDesc());
        pageInfoMapper.insert(pageInfo);
    }

    @RequestMapping(value = "/getinfos", method = RequestMethod.GET)
    @ResponseBody
    public List<PageInfo> getPageIdInfos () {
        List<PageInfo> pageInfos = pageInfoMapper.selectAllPageIdOrderByDesc();
        return pageInfoMapper.selectAllPageIdOrderByDesc();
    }

    @RequestMapping(value = "/saveinfos", method = RequestMethod.POST)
    @ResponseBody
    public void saveInfos (@RequestBody IndexInfoAll indexInfoDesc) {
        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setDeptId(indexInfoDesc.getDeptId());
        indexInfo.setDescription(indexInfoDesc.getDesc());
        indexInfo.setIndex(indexInfoDesc.getIndex());
        indexInfo.setPageId(indexInfoDesc.getPageId());
        indexInfoMapper.insert(indexInfo);
    }
}
