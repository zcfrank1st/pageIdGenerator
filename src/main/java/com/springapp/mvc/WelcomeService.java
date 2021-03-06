package com.springapp.mvc;

import com.springapp.mvc.entity.mybatis.IndexInfo;
import com.springapp.mvc.entity.mybatis.IndexInfoExample;
import com.springapp.mvc.entity.mybatis.PageInfo;
import com.springapp.mvc.entity.mybatis.PageInfoExample;
import com.springapp.mvc.entity.origin.IndexInfoAdvance;
import com.springapp.mvc.entity.origin.IndexInfoAll;
import com.springapp.mvc.entity.origin.PageIdAll;
import com.springapp.mvc.mappers.IndexInfoMapper;
import com.springapp.mvc.mappers.PageInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public int generatePageIdAndSave (PageIdAll pageIdDesc) {
        try {
            PageInfo pageInfo = new PageInfo();
            pageInfo.setPageName(pageIdDesc.getPageIdName());
            pageInfo.setDescription(pageIdDesc.getPageIdDesc());
            pageInfo.setDeptId(pageIdDesc.getDeptId());
            pageInfo.setTypeId(pageIdDesc.getTypeId());
            pageInfo.setCreateTime(new Date());
            pageInfo.setUpdateTime(new Date());
            pageInfo.setIsValid(1);
            pageInfo.setUrlReg(pageIdDesc.getUrlReg());
            return pageInfoMapper.insert(pageInfo);
        }catch(Exception e) {
            return -1;
        }
    }

    public List<PageInfo> getPageIdInfos () {
        PageInfoExample pageInfoExample = new PageInfoExample();
        pageInfoExample.or().andIsValidEqualTo(1);
        pageInfoExample.setOrderByClause("page_id desc");
        return pageInfoMapper.selectByExample(pageInfoExample);
    }

    public int generateModuleAndSave (IndexInfoAll indexInfoDesc) {
        try {
            IndexInfo indexInfo = new IndexInfo();
            indexInfo.setDeptId(indexInfoDesc.getDeptId());
            indexInfo.setDescription(indexInfoDesc.getDesc());
            indexInfo.setIndexName(indexInfoDesc.getIndex());
            indexInfo.setPageId(indexInfoDesc.getPageId());
            indexInfo.setTypeId(indexInfoDesc.getTypeId());
            indexInfo.setCreateTime(new Date());
            indexInfo.setUpdateTime(new Date());
            indexInfo.setIsValid(1);
            indexInfo.setActionType(indexInfoDesc.getActionType());
            return indexInfoMapper.insert(indexInfo);
        } catch (Exception e) {
            return -1;
        }
    }

    public List<PageInfo> showPages(int departmentId) {
        PageInfoExample pageInfoExample = new PageInfoExample();
        pageInfoExample.or().andDeptIdEqualTo(departmentId).andIsValidEqualTo(1);
        return pageInfoMapper.selectByExample(pageInfoExample);
    }

    public List<IndexInfoAdvance> showModules(int departmentId, int pageId) {
        IndexInfoExample indexInfoExample =  new IndexInfoExample();
        indexInfoExample.or().andDeptIdEqualTo(departmentId).andPageIdEqualTo(pageId).andIsValidEqualTo(1);
        List<IndexInfo> indexInfos =  indexInfoMapper.selectByExample(indexInfoExample);

        List<IndexInfoAdvance> newIndexInfo = new ArrayList<IndexInfoAdvance>();
        for (IndexInfo indexInfo: indexInfos) {
            PageInfoExample pageInfoExample = new PageInfoExample();
            pageInfoExample.or().andPageIdEqualTo(indexInfo.getPageId());
            PageInfo currentPageInfo = (pageInfoMapper.selectByExample(pageInfoExample)).get(0);

            IndexInfoAdvance indexInfoAdvance = new IndexInfoAdvance(indexInfo);
            indexInfoAdvance.setPageName(currentPageInfo.getPageName());
            newIndexInfo.add(indexInfoAdvance);
        }

        return newIndexInfo;
    }

    public int delPage(int id) {
        PageInfoExample pageInfoExample = new PageInfoExample();
        pageInfoExample.or().andPageIdEqualTo(id);
        List<PageInfo> pageInfos = pageInfoMapper.selectByExample(pageInfoExample);

        PageInfo pageInfo = pageInfos.get(0);
        pageInfo.setIsValid(0);

        delRalativeModules(id);
        return pageInfoMapper.updateByExample(pageInfo, pageInfoExample);
    }

    private void delRalativeModules(int pageId) {
        IndexInfoExample indexInfoExample = new IndexInfoExample();
        indexInfoExample.or().andPageIdEqualTo(pageId).andIsValidEqualTo(1);
        List<IndexInfo> indexInfos = indexInfoMapper.selectByExample(indexInfoExample);

        for (IndexInfo indexInfo: indexInfos) {
            indexInfo.setIsValid(0);
            IndexInfoExample indexInfoExample1 = new IndexInfoExample();
            indexInfoExample1.or().andIdEqualTo(indexInfo.getId());
            indexInfoMapper.updateByExample(indexInfo, indexInfoExample1);
        }
    }

    public int delModule(int id) {
        IndexInfoExample indexInfoExample = new IndexInfoExample();
        indexInfoExample.or().andIdEqualTo(id);
        List<IndexInfo> indexInfos = indexInfoMapper.selectByExample(indexInfoExample);

        IndexInfo indexInfo =  indexInfos.get(0);
        indexInfo.setIsValid(0);
        return indexInfoMapper.updateByExample(indexInfo, indexInfoExample);
    }

    public int updatePage(PageIdAll pageIdAll) {
        PageInfoExample pageInfoExample = new PageInfoExample();
        pageInfoExample.or().andPageIdEqualTo(pageIdAll.getId());

        PageInfo pageInfo1 = new PageInfo();
        pageInfo1.setDeptId(pageIdAll.getDeptId());
        pageInfo1.setDescription(pageIdAll.getPageIdDesc());
        pageInfo1.setPageName(pageIdAll.getPageIdName());
        pageInfo1.setTypeId(pageIdAll.getTypeId());
        pageInfo1.setUpdateTime(new Date());
        pageInfo1.setUrlReg(pageIdAll.getUrlReg());

        return pageInfoMapper.updateByExampleSelective(pageInfo1, pageInfoExample);
    }

    public int updateModule(IndexInfoAll indexInfoAll) {
        IndexInfoExample indexInfoExample = new IndexInfoExample();
        indexInfoExample.or().andIdEqualTo(indexInfoAll.getId());

        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setDeptId(indexInfoAll.getDeptId());
        indexInfo.setDescription(indexInfoAll.getDesc());
        indexInfo.setIndexName(indexInfoAll.getIndex());
        indexInfo.setPageId(indexInfoAll.getPageId());
        indexInfo.setTypeId(indexInfoAll.getTypeId());

        return indexInfoMapper.updateByExampleSelective(indexInfo, indexInfoExample);
    }

    public List<PageInfo> showAllPages() {
        PageInfoExample pageInfoExample = new PageInfoExample();
        pageInfoExample.or().andIsValidEqualTo(1);

        return pageInfoMapper.selectByExample(pageInfoExample);
    }

    public List<IndexInfoAdvance> showAllModules() {
        IndexInfoExample indexInfoExample = new IndexInfoExample();
        indexInfoExample.or().andIsValidEqualTo(1);
        List<IndexInfo> indexInfos = indexInfoMapper.selectByExample(indexInfoExample);

        List<IndexInfoAdvance> newIndexInfo = new ArrayList<IndexInfoAdvance>();
        for (IndexInfo indexInfo: indexInfos) {
            PageInfoExample pageInfoExample = new PageInfoExample();
            pageInfoExample.or().andPageIdEqualTo(indexInfo.getPageId());
            PageInfo currentPageInfo = (pageInfoMapper.selectByExample(pageInfoExample)).get(0);

            IndexInfoAdvance indexInfoAdvance = new IndexInfoAdvance(indexInfo);
            indexInfoAdvance.setPageName(currentPageInfo.getPageName());
            newIndexInfo.add(indexInfoAdvance);
        }

        return newIndexInfo;
    }
}
