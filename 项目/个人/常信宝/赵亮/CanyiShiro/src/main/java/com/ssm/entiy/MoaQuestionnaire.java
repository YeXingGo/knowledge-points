package com.ssm.entiy;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-03-11
 */
public class MoaQuestionnaire {
    private Integer id;

    private String qname;

    private Date begindate;

    private Date enddate;

    private Integer selectcount;

    private Integer checkcount;

    private Integer judgecount;

    private Integer qacount;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname == null ? null : qname.trim();
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getSelectcount() {
        return selectcount;
    }

    public void setSelectcount(Integer selectcount) {
        this.selectcount = selectcount;
    }

    public Integer getCheckcount() {
        return checkcount;
    }

    public void setCheckcount(Integer checkcount) {
        this.checkcount = checkcount;
    }

    public Integer getJudgecount() {
        return judgecount;
    }

    public void setJudgecount(Integer judgecount) {
        this.judgecount = judgecount;
    }

    public Integer getQacount() {
        return qacount;
    }

    public void setQacount(Integer qacount) {
        this.qacount = qacount;
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
}