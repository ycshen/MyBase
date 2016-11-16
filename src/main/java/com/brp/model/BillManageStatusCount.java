package com.brp.model;

/**
 * 总部面单管理状态数量
 * Created by Administrator on 2016/11/3.
 */
public class BillManageStatusCount {
    /**
     * 生产中
     */
    private Long billProductCount;
    /**
     * 当前库存
     */
    private Long billRepertoryCount;
    /**
     * 累计出库数量
     */
    private Long billOutWarehouseCount;

    /**
     * 累计作废数量
     */
    private Long billInvalidCount;

    public Long getBillProductCount() {
        return billProductCount;
    }

    public void setBillProductCount(Long billProductCount) {
        this.billProductCount = billProductCount;
    }

    public Long getBillRepertoryCount() {
        return billRepertoryCount;
    }

    public void setBillRepertoryCount(Long billRepertoryCount) {
        this.billRepertoryCount = billRepertoryCount;
    }

    public Long getBillOutWarehouseCount() {
        return billOutWarehouseCount;
    }

    public void setBillOutWarehouseCount(Long billOutWarehouseCount) {
        this.billOutWarehouseCount = billOutWarehouseCount;
    }

    public Long getBillInvalidCount() {
        return billInvalidCount;
    }

    public void setBillInvalidCount(Long billInvalidCount) {
        this.billInvalidCount = billInvalidCount;
    }
}
