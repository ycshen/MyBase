package com.brp.entity;

import com.fasterxml.jackson.databind.deser.Deserializers;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/3/23
 * @Desc MyBase-com.brp.entity
 */
public class EmailTemplateEntity extends BaseEntity{
    private String templateCode; //模板code
    private String templateName; //模板名称
    private String templateContent; //模板内容
    private Integer status; //状态 0-正常 1-停用
    private String remark; //备注

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
