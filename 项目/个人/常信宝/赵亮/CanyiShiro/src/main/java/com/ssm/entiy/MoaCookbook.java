package com.ssm.entiy;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-03-11
 */
public class MoaCookbook {
    /**
     * 菜谱编号（主键）
     */
    private Integer id;

    /**
     * 周编号（外键：周表-周编号）
     */
    private Integer weekId;

    /**
     * 当天日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cdate;

    /**
     * 当天周几
     */
    private String cweek;

    /**
     * 早餐
     */
    private String breakfast;

    /**
     * 午餐
     */
    private String lunch;

    /**
     * 创建者
     */
    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    /**
     * 删除标记（0：正常   1：删除） 默认值 0
     */
    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeekId() {
        return weekId;
    }

    public void setWeekId(Integer weekId) {
        this.weekId = weekId;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getCweek() {
        return cweek;
    }

    public void setCweek(String cweek) {
        this.cweek = cweek == null ? null : cweek.trim();
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast == null ? null : breakfast.trim();
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch == null ? null : lunch.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

	@Override
	public String toString() {
		return "MoaCookbook [id=" + id + ", weekId=" + weekId + ", cdate=" + cdate + ", cweek=" + cweek + ", breakfast="
				+ breakfast + ", lunch=" + lunch + ", createBy=" + createBy + ", createDate=" + createDate
				+ ", updateBy=" + updateBy + ", updateDate=" + updateDate + ", remarks=" + remarks + ", delFlag="
				+ delFlag + "]";
	}
    
}