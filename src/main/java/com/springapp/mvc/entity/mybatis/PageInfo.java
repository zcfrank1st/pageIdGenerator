package com.springapp.mvc.entity.mybatis;

import java.util.Date;

public class PageInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oasis_page.page_id
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    private Integer pageId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oasis_page.page_name
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    private String pageName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oasis_page.owner
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    private String owner;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oasis_page.create_time
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oasis_page.update_time
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oasis_page.description
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oasis_page.page_id
     *
     * @return the value of oasis_page.page_id
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public Integer getPageId() {
        return pageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oasis_page.page_id
     *
     * @param pageId the value for oasis_page.page_id
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oasis_page.page_name
     *
     * @return the value of oasis_page.page_name
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public String getPageName() {
        return pageName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oasis_page.page_name
     *
     * @param pageName the value for oasis_page.page_name
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public void setPageName(String pageName) {
        this.pageName = pageName == null ? null : pageName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oasis_page.owner
     *
     * @return the value of oasis_page.owner
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public String getOwner() {
        return owner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oasis_page.owner
     *
     * @param owner the value for oasis_page.owner
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oasis_page.create_time
     *
     * @return the value of oasis_page.create_time
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oasis_page.create_time
     *
     * @param createTime the value for oasis_page.create_time
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oasis_page.update_time
     *
     * @return the value of oasis_page.update_time
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oasis_page.update_time
     *
     * @param updateTime the value for oasis_page.update_time
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oasis_page.description
     *
     * @return the value of oasis_page.description
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oasis_page.description
     *
     * @param description the value for oasis_page.description
     *
     * @mbggenerated Tue Jul 07 17:52:56 CST 2015
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}