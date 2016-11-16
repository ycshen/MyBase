/*
package brp;

import com.brp.base.Constant;
import com.brp.service.impl.BillInitServiceImpl;
import com.brp.util.api.PMSApiUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

*/
/**
 * Created by Administrator on 2016/9/1.
 *//*

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class TestPMS {

    @Test
    public void  testConfig() {
        String allDistrict = PMSApiUtils.queryBillNumExist("123", "123");

        ObjectMapper objectMapper = new ObjectMapper();
        List<Integer> list = null;
        try {
            list = objectMapper.readValue(allDistrict, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Integer ss : list) {

        System.out.println(ss);
        }
    }


}
*/
