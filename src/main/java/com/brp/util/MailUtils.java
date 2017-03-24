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
}
