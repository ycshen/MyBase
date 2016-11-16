/** * PropertiesUtils.java 
* Created on 2015年7月20日 上午11:18:18 
*/

package com.brp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** 
 * <p>Project: BRP</p> 
 * <p>Title: PropertiesUtils.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class PropertiesUtils {
	/**
	 * 读取配置文件
	 * @return
	 * @throws IOException
	 */
	public static Properties readConfig() throws IOException {
		InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("properties/config.properties");
		Properties p = new Properties();
		p.load(in);
		return p;
	}
}
