package com.springapp.mvc.entity.origin;

/**
 * Created by zcfrank1st on 7/7/15.
 */
public class PageIdAll {
    private int id;
    private String pageIdName;
    private int pageId;
    private String pageIdDesc;
    private String owner;
    private int typeId;
    private int isValid;
    private String urlReg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlReg() {
        return urlReg;
    }

    public void setUrlReg(String urlReg) {
        this.urlReg = urlReg;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    private int deptId;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPageIdName() {
        return pageIdName;
    }

    public void setPageIdName(String pageIdName) {
        this.pageIdName = pageIdName;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getPageIdDesc() {
        return pageIdDesc;
    }

    public void setPageIdDesc(String pageIdDesc) {
        this.pageIdDesc = pageIdDesc;
    }
}
