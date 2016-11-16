package com.brp.checkcode;

/**
 * Created by Administrator on 2016/8/30.
 */
public class CheckCodeSum implements BaseCheckCodeService {
    @Override
    public Integer getCheckCode(Integer billType, Integer businessCode ,Integer setSerialNumber) {
        int sum=billType+businessCode+setSerialNumber;
        String temp=String.valueOf(sum);
        // 取最后一位
        return  Integer.parseInt(temp.substring(temp.length()-1,temp.length()));
    }

    @Override
    public String getCheckName() {
        return "CheckCodeSum";
    }

    @Override
    public boolean checkBill(String billNum) {

        Integer billType =Integer.parseInt(billNum.substring(0,1));
        Integer businessCode = Integer.parseInt(billNum.substring(1,2));
       /* Integer district = Integer.parseInt(billNum.substring(2,5));*/

        //序列号 4444444
        Integer serialNumber = Integer.parseInt(billNum.substring(5,12));
        Integer checkcode = Integer.parseInt(billNum.substring(12,13));

        int sum=billType+businessCode+serialNumber;
        String temp=String.valueOf(sum);

        if(Integer.parseInt(temp.substring(temp.length()-1,temp.length()))==checkcode){
            return true;
        }else{
            return false;
        }

    }
}
