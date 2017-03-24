package com.brp.util;

import com.brp.entity.EmailConfigEntity;
import com.brp.entity.EmailTemplateEntity;
import com.brp.mapper.EmailConfigMapper;
import com.brp.mapper.EmailTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/3/24
 * @Desc MyBase-com.brp.util
 */
@Component
public class MailUtils {
    private static String TEMPLATE_REGISTER = "REGISTER";
    private static String CONFIG_REGISTER = "REGISTER";
    private static String TEMPLATE_ACTIVE= "ACTIVE";
    private static String CONFIG_ACTIVE = "ACTIVE";
    private static String TEMPLATE_MODIFY_PASSWORD = "MODIFY_PASSWORD";
    private static String CONFIG_MODIFY_PASSWORD = "MODIFY_PASSWORD";
    private static EmailTemplateMapper templateMapper;
    private static EmailConfigMapper configMapper;
    @Autowired(required = true)
    public void setTemplateMapper(EmailTemplateMapper templateMapper){
        MailUtils.templateMapper = templateMapper;
    }
    @Autowired(required = true)
    public void setConfigMapper(EmailConfigMapper configMapper){
        MailUtils.configMapper = configMapper;
    }

    /**
     * 发送注册邮件
     * @param toEmail 发送到用户邮箱地址
     * @param toUser 用户名
     * @return 返回是否成功
     * @throws Exception
     */
    public static Boolean sendRegisterEmail(String toEmail, String toUser) throws Exception{
        EmailTemplateEntity emailTemplate = templateMapper.getEmailTemplateByCode(TEMPLATE_REGISTER);
        if(emailTemplate == null){
            throw  new RuntimeException("邮件模板不存在");
        }

        if(emailTemplate.getStatus() == 1){
            throw  new RuntimeException("邮件模板已被停用");
        }

        EmailConfigEntity config = configMapper.getEmailConfigByCode(CONFIG_REGISTER);
        if(config == null){
            throw  new RuntimeException("邮件配置不存在");
        }

        if(config.getStatus() == 0){
            throw  new RuntimeException("邮件配置已被停用");
        }

        String templateContent = emailTemplate.getTemplateContent();
        templateContent = templateContent.replaceAll("T_O_U_S_E_R", toUser);
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setContent(templateContent);
        mailInfo.setFromAddress(config.getFromAddress());
        mailInfo.setMailServerHost(config.getMailServerHost());
        mailInfo.setMailServerPort(config.getMailServerPort());
        mailInfo.setPassword(config.getPassword());
        mailInfo.setSubject(emailTemplate.getSubject());
        mailInfo.setToAddress(toEmail);
        mailInfo.setUserName(config.getUserName());
        mailInfo.setValidate(true);

        SimpleMailSender.sendHtmlMail(mailInfo);
        return true;
    }

    /**
     * 发送分配账号邮件
     * @param toEmail 发送到用户邮箱地址
     * @param toUser 用户名
     * @return 返回是否成功
     * @throws Exception
     */
    public static Boolean sendAssignEmail(String toEmail, String toUser, String pwd, String tel, String company, String department) throws Exception{
        EmailTemplateEntity emailTemplate = templateMapper.getEmailTemplateByCode(TEMPLATE_ACTIVE);
        if(emailTemplate == null){
            throw  new RuntimeException("邮件模板不存在");
        }

        if(emailTemplate.getStatus() == 1){
            throw  new RuntimeException("邮件模板已被停用");
        }

        EmailConfigEntity config = configMapper.getEmailConfigByCode(CONFIG_ACTIVE);
        if(config == null){
            throw  new RuntimeException("邮件配置不存在");
        }

        if(config.getStatus() == 0){
            throw  new RuntimeException("邮件配置已被停用");
        }

        String templateContent = emailTemplate.getTemplateContent();
        /*USR_TEL：注册电话号码
        T_O_U_S_E_R:用户名
        COMPANY_NAME：公司名称
        DEPT_NAME： 部门名称
        USR_PWD： 初始化密码
        USR_EMAIL：电子邮箱地址*/
        templateContent = templateContent.replaceAll("USR_TEL", tel);
        templateContent = templateContent.replaceAll("T_O_U_S_E_R", toUser);
        templateContent = templateContent.replaceAll("COMPANY_NAME", company);
        templateContent = templateContent.replaceAll("DEPT_NAME", department);
        templateContent = templateContent.replaceAll("USR_PWD", pwd);
        templateContent = templateContent.replaceAll("USR_EMAIL", toEmail);
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setContent(templateContent);
        mailInfo.setFromAddress(config.getFromAddress());
        mailInfo.setMailServerHost(config.getMailServerHost());
        mailInfo.setMailServerPort(config.getMailServerPort());
        mailInfo.setPassword(config.getPassword());
        mailInfo.setSubject(emailTemplate.getSubject());
        mailInfo.setToAddress(toEmail);
        mailInfo.setUserName(config.getUserName());
        mailInfo.setValidate(true);

        SimpleMailSender.sendHtmlMail(mailInfo);
        return true;
    }
}
