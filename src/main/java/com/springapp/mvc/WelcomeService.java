package com.springapp.mvc;

import com.springapp.mvc.entity.mybatis.IndexInfo;
import com.springapp.mvc.entity.mybatis.IndexInfoExample;
import com.springapp.mvc.entity.mybatis.PageInfo;
import com.springapp.mvc.entity.mybatis.PageInfoExample;
import com.springapp.mvc.entity.origin.IndexInfoAll;
import com.springapp.mvc.entity.origin.PageIdAll;
import com.springapp.mvc.mappers.IndexInfoMapper;
import com.springapp.mvc.mappers.PageInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        pageInfo.setDeptId(pageIdDesc.getDeptId());
        pageInfo.setTypeId(pageIdDesc.getTypeId());
        pageInfo.setCreateTime(new Date());
        pageInfo.setUpdateTime(new Date());
        pageInfo.setIsValid(1);
        pageInfoMapper.insert(pageInfo);
    }

    public List<PageInfo> getPageIdInfos () {
        PageInfoExample pageInfoExample = new PageInfoExample();
        pageInfoExample.or().andIsValidEqualTo(1);
        pageInfoExample.setOrderByClause("page_id desc");
        return pageInfoMapper.selectByExample(pageInfoExample);
    }

    public void generateModuleAndSave (IndexInfoAll indexInfoDesc) {
        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setDeptId(indexInfoDesc.getDeptId());
        indexInfo.setDescription(indexInfoDesc.getDesc());
        indexInfo.setIndexName(indexInfoDesc.getIndex());
        indexInfo.setPageId(indexInfoDesc.getPageId());
        indexInfo.setTypeId(indexInfoDesc.getTypeId());
        indexInfo.setCreateTime(new Date());
        indexInfo.setUpdateTime(new Date());
        indexInfo.setIsValid(1);
        indexInfoMapper.insert(indexInfo);
    }

    public List<PageInfo> showPages(int departmentId) {
        PageInfoExample pageInfoExample = new PageInfoExample();
        pageInfoExample.or().andDeptIdEqualTo(departmentId);
        pageInfoExample.setOrderByClause("page_id desc");
        return pageInfoMapper.selectByExample(pageInfoExample);
    }

    public List<IndexInfo> showModules(int departmentId, int pageId) {
        IndexInfoExample indexInfoExample =  new IndexInfoExample();
        indexInfoExample.or().andDeptIdEqualTo(departmentId).andPageIdEqualTo(pageId);
        indexInfoExample.setOrderByClause("id desc");
        return indexInfoMapper.selectByExample(indexInfoExample);
    }

    public void delPage() {

    }

    public void delModule() {

    }
}
