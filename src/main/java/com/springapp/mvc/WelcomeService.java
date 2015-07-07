package com.springapp.mvc;

import com.springapp.mvc.entity.mybatis.IndexInfo;
import com.springapp.mvc.entity.mybatis.PageInfo;
import com.springapp.mvc.entity.origin.IndexInfoAll;
import com.springapp.mvc.entity.origin.PageIdAll;
import com.springapp.mvc.mappers.IndexInfoMapper;
import com.springapp.mvc.mappers.PageInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcfrank1st on 7/7/15.
 */
@Service
public class WelcomeService {
    @Autowired
    private IndexInfoMapper indexInfoMapper;
    @Autowired
    private PageInfoMapper pageInfoMapper;

    public void generatePageIdAndSave (PageIdAll pageIdDesc) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageName(pageIdDesc.getPageIdName());
        pageInfo.setDescription(pageIdDesc.getPageIdDesc());
        pageInfoMapper.insert(pageInfo);
    }

    public List<PageInfo> getPageIdInfos () {
        List<PageInfo> pageInfos = pageInfoMapper.selectAllPageIdOrderByDesc();
        return pageInfoMapper.selectAllPageIdOrderByDesc();
    }

    public void saveInfos (IndexInfoAll indexInfoDesc) {
        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setDeptId(indexInfoDesc.getDeptId());
        indexInfo.setDescription(indexInfoDesc.getDesc());
        indexInfo.setIndex(indexInfoDesc.getIndex());
        indexInfo.setPageId(indexInfoDesc.getPageId());
        indexInfoMapper.insert(indexInfo);
    }
}
