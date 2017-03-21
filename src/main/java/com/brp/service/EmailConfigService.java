package com.brp.service;

import com.brp.entity.EmailConfigEntity;
import com.brp.util.query.EmailConfigQuery;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/3/17
 * @Desc MyBase-com.brp.service
 */
public interface EmailConfigService {
	void insertEmailConfig(EmailConfigEntity emailConfig);
	void updateEmailConfig(EmailConfigEntity emailConfig);
	EmailConfigEntity getEmailConfigById(String id);
	EmailConfigQuery getEmailConfigPage(EmailConfigQuery emailConfigQuery);
	void switchStatus(String id, Integer status);
}
