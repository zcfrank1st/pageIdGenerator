package com.springapp.mvc.entity.origin;

import com.springapp.mvc.entity.mybatis.IndexInfo;

import java.util.Date;

/**
 * Created by zcfrank1st on 8/10/15.
 */
public class IndexInfoAdvance {
    private Integer id;
    private String indexName;
    private String description;
    private Integer pageId;
    private Integer deptId;
    private String owner;
    private Date createTime;
    private Date updateTime;
    private Integer typeId;
    private Integer isValid;
    private String actionType;
    private String pageName;

    public IndexInfoAdvance(IndexInfo indexInfo) {
        this.id = indexInfo.getId();
        this.indexName = indexInfo.getIndexName();
        this.description = indexInfo.getDescription();
        this.pageId = indexInfo.getPageId();
        this.deptId = indexInfo.getDeptId();
        this.owner = indexInfo.getOwner();
        this.createTime = indexInfo.getCreateTime();
        this.updateTime = indexInfo.getUpdateTime();
        this.typeId = indexInfo.getTypeId();
        this.isValid = indexInfo.getIsValid();
        this.actionType = indexInfo.getActionType();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
}
