package com.ssm.entiy;

import java.util.Date;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-03-11
 */
public class MoaQuestionnaireresult {
    /**
     * 结果编号（主键）
     */
    private Integer id;

    /**
     * 问卷编号（外键：问卷表-编号）
     */
    private Integer questionnaireId;

    /**
     * 题目类型
     */
    private String qtype;

    /**
     * 题目序号
     */
    private Integer qnumber;

    /**
     * 回答结果
     */
    private String qresult;

    /**
     * 用户编号（外键：用户表-编号）
     */
    private Integer userId;

    /**
     * 回答时间
     */
    private Date answerdate;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记（0：正常  1：删除） 默认值  0
     */
    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype == null ? null : qtype.trim();
    }

    public Integer getQnumber() {
        return qnumber;
    }

    public void setQnumber(Integer qnumber) {
        this.qnumber = qnumber;
    }

    public String getQresult() {
        return qresult;
    }

    public void setQresult(String qresult) {
        this.qresult = qresult == null ? null : qresult.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getAnswerdate() {
        return answerdate;
    }

    public void setAnswerdate(Date answerdate) {
        this.answerdate = answerdate;
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