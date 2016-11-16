package com.brp.util.dal;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * dao层的性能拦截类,用于统计dal层操作的耗时
 * 
 * @author Administrator
 *
 */
public class DalMethodInterceptor implements MethodInterceptor {

	private final static  Logger logger = LoggerFactory.getLogger(DalMethodInterceptor.class);

	private static Map<String,Object> typeMap = new HashMap<>();
	{
		typeMap.put("int",0);
		typeMap.put("double",0.00);
		typeMap.put("long",0);
	}
	
	/**
	 * 阀值超过该阀值就是warn 级别的日志 
	 */
	private int threshold=50;

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		long start = System.currentTimeMillis();
		try {

			Object object = arg0.proceed();
			if(null==object &&!"Void".equalsIgnoreCase(arg0.getMethod().getReturnType().getSimpleName())&&arg0.getMethod().getReturnType().isPrimitive()){
				logger.warn("method return is Primitive ,result is null.");
				return typeMap.get(arg0.getMethod().getReturnType());
			}
			return object;
		} catch (Exception e) {
			Object[] objs = arg0.getArguments();
			logger.error("数据库执行异常,方法名：" + arg0.getMethod().getName() + "参数:" + getShortArgs(objs), e);
			throw e;
		}finally{
			long end = System.currentTimeMillis();
			long i  =(end - start);
			String result = arg0.getMethod().getDeclaringClass().getSimpleName() + "."
					+ arg0.getMethod().getName()
					+ getShortArgs(arg0.getArguments()) + " use " + i
					+ "ms.";
			if(i>threshold){
				logger.warn(result);
			}else{
				logger.info(result);
			}
		}
	}
	
	/**
	 * 获取参数列表
	 * 
	 * @param obj
	 * @return
	 */
	private String getShortArgs(Object[] obj) {
		StringBuilder builder = new StringBuilder("(");
		for (Object o : obj) {
			if(null==o){
				continue;
			}
			if (o.getClass().isPrimitive()) {
				builder.append(o);
			} else {
				builder.append(o.getClass().getSimpleName());
			}
			builder.append(",");
		}
		if(builder.toString().endsWith(",")){
			builder.deleteCharAt(builder.length() - 1);
		}
		return builder.append(")").toString();
	}

}
