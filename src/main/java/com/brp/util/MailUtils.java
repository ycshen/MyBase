package com.brp.util;

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
    private static EmailTemplateMapper templateMapper;
    private static EmailConfigMapper configMapper;
    @Autowired(required = true)
    public void setTemplateMapper(EmailTemplateMapper templateMapper){
        MailUtils.templateMapper = templateMapper;
    }

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

        String templateContent = emailTemplate.getTemplateContent();
        templateContent = templateContent.replaceAll("T_O_U_S_E_R", toUser);
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setContent(templateContent);
        mailInfo.setFromAddress("449614531@qq.com");
        mailInfo.setMailServerHost("smtp.qq.com");
        mailInfo.setMailServerPort("587");
        mailInfo.setPassword("jvbiulzewfamcahf");
        mailInfo.setSubject(emailTemplate.getSubject());
        mailInfo.setToAddress(toEmail);
        mailInfo.setUserName("449614531@qq.com");
        mailInfo.setValidate(true);

        SimpleMailSender.sendHtmlMail(mailInfo);
        return true;
    }
}
