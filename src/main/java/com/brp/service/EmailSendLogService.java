package com.brp.service;

import com.brp.entity.EmailSendLogEntity;
import com.brp.util.query.EmailSendLogQuery;

import java.util.List;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/3/17
 * @Desc MyBase-com.brp.service
 */
public interface EmailSendLogService {
    void insertEmailSendLog(EmailSendLogEntity emailSendLog);
    EmailSendLogQuery getEmailSendLogPage(EmailSendLogQuery emailSendLogQuery);
    EmailSendLogEntity getEmailSendLogById(Integer id);
}
