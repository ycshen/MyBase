package com.brp.checkcode;

/**
 * Created by Administrator on 2016/8/30.
 */
public interface BaseCheckCodeService {

   /**
    * 获取校验码
    * @param billType
    * @param businessCode
    * @param setSerialNumber
     * @return
     */
    Integer getCheckCode(Integer billType,Integer businessCode,Integer setSerialNumber);

    String getCheckName();

    boolean checkBill(String billNum);
}
