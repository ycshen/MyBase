package com.brp.util.redisCache;

import java.lang.annotation.*;

/**
 * �з�����
 * Created by Administrator on 2016/5/5.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {
    public enum KeyMode{
        DEFAULT,    
        BASIC,    
        ALL;       
    }

    public String key() default "";   
    public KeyMode keyMode() default KeyMode.DEFAULT; 
    public int expire() default 0; 
}
