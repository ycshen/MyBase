package com.brp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * 配置文件config.properties
 * @author 
 *
 */
public class ConfigUtils {
    private static final Logger log = LoggerFactory.getLogger(ConfigUtils.class);
    private static Properties pro=new Properties();
    private static final String configName="datasource.properties";
    static{
        try {
            pro.load(ConfigUtils.class.getClassLoader().getResourceAsStream(configName));
        } catch (Exception e) {
            log.error("load config file error", e);
            e.printStackTrace();
        }
    }

    /**
     * 获得配置文件中指定key对应的value，如果没有此key则返回空字符
     */
    public static String getString(String key){
        return getString(key, "");
    }
    /**
     * 获得配置文件中指定key对应的value，如果没有此key则返回指定的默认值
     */
    public static String getString(String key,String defaultValue){
        String result=defaultValue;
        try{
            result=pro.getProperty(key,result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 获得配置文件中指定key对应的long型value，如果没有此key则返回-1
     */
    public static long getLong(String key){
        return getLong(key,-1);
    }
    /**
     * 获得配置文件中指定key对应的long型value，如果没有此key则返回指定的默认值
     */
    public static long getLong(String key,long defaultValue){
    	long result=defaultValue;
        try{
            String value=pro.getProperty(key,result+"");
        	result=value.matches("-?\\d+")?Long.parseLong(value):result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 获得配置文件中指定key对应的int型value，如果没有此key则返回-1
     */
    public static int getInt(String key){
        return getInt(key,-1);
    }
    /**
     * 获得配置文件中指定key对应的int型value，如果没有此key则返回指定的默认值
     */
    public static int getInt(String key,int defaultValue){
    	int result=defaultValue;
        try{
            String value=pro.getProperty(key,result+"");
        	result=value.matches("-?\\d+")?Integer.parseInt(value):result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
