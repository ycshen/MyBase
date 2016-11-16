package com.brp.model;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HomeCountModel {
    private String billTypeUsableCount;
    private String billTypeUnusableCount;
    private String districtUsableCount;
    private String districtUnusableCount;
    private String billInitCount;
    private String warehouseOutCount;

    public String getBillTypeUsableCount() {
        return billTypeUsableCount;
    }

    public void setBillTypeUsableCount(String billTypeUsableCount) {
        this.billTypeUsableCount = billTypeUsableCount;
    }

    public String getBillTypeUnusableCount() {
        return billTypeUnusableCount;
    }

    public void setBillTypeUnusableCount(String billTypeUnusableCount) {
        this.billTypeUnusableCount = billTypeUnusableCount;
    }

    public String getDistrictUsableCount() {
        return districtUsableCount;
    }

    public void setDistrictUsableCount(String districtUsableCount) {
        this.districtUsableCount = districtUsableCount;
    }

    public String getDistrictUnusableCount() {
        return districtUnusableCount;
    }

    public void setDistrictUnusableCount(String districtUnusableCount) {
        this.districtUnusableCount = districtUnusableCount;
    }

    public String getBillInitCount() {
        return billInitCount;
    }

    public void setBillInitCount(String billInitCount) {
        this.billInitCount = billInitCount;
    }

    public String getWarehouseOutCount() {
        return warehouseOutCount;
    }

    public void setWarehouseOutCount(String warehouseOutCount) {
        this.warehouseOutCount = warehouseOutCount;
    }
}
