/*package brp;

import com.brp.entity.BillManageModel;
import com.brp.model.ResultModel;
import com.brp.service.BillInitService;
import com.brp.service.BillManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;


*//**
 * Created by Administrator on 2016/10/18.
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class BaseTest {
    @Autowired
    private BillManageService billManageService;

    @Test
    public void getBillTest(){
        BillManageModel billManageModel = new BillManageModel();
        billManageModel.setDeptId(2);
        billManageModel.setBillType(1);
        billManageModel.setBusinessType(6);
        ResultModel<Object> resultModel = billManageService.saveBillException(billManageModel);

      *//*  List<BillManageModel> billManageModels = billManageService.queryBillRepertoryCount(billManageModel);
        for (BillManageModel bm: billManageModels) {
            System.out.println(bm);
        }*//*
    }
}*//*package brp;

import com.brp.entity.BillManageModel;
import com.brp.model.ResultModel;
import com.brp.service.BillInitService;
import com.brp.service.BillManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;


*//**
 * Created by Administrator on 2016/10/18.
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class BaseTest {
    @Autowired
    private BillManageService billManageService;

    @Test
    public void getBillTest(){
        BillManageModel billManageModel = new BillManageModel();
        billManageModel.setDeptId(2);
        billManageModel.setBillType(1);
        billManageModel.setBusinessType(6);
        ResultModel<Object> resultModel = billManageService.saveBillException(billManageModel);

      *//*  List<BillManageModel> billManageModels = billManageService.queryBillRepertoryCount(billManageModel);
        for (BillManageModel bm: billManageModels) {
            System.out.println(bm);
        }*//*
    }
}*/

