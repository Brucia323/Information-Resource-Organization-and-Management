package zcy.socialpension;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import zcy.socialpension.services.GetPersonList;
import zcy.socialpension.services.ImportToNeo4j;

import javax.annotation.Resource;

@SpringBootTest
class SocialPensionApplicationTests {
    @Resource
    ImportToNeo4j importToNeo4j;
    @Resource
    GetPersonList getPersonList;

    @Test
    void contextLoads() {
        System.out.println(getPersonList.getReceiveAfterDeath());
    }

    @Test
    void initData() {
        String filename = "static/mzhh_殡仪馆火化数据_202012.CSV";
        importToNeo4j.importCremationData(filename);
        filename = "static/jgyl_06待遇支付明细表.CSV";
        importToNeo4j.importTreatmentPaymentDetail(filename);
        filename = "static/jgyl_02个人基本信息表.CSV";
        importToNeo4j.importAgencyPerson(filename);
        filename = "static/zgyl_02个人基本信息表.CSV";
        importToNeo4j.importEmployeePerson(filename);
    }

}
