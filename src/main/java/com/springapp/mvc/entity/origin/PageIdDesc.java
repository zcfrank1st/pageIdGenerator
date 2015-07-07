package com.springapp.mvc.entity.origin;

/**
 * Created by zcfrank1st on 7/7/15.
 */
public class PageIdDesc {
    private String pageIdName;
    private int pageId;
    private String owner;

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
}
