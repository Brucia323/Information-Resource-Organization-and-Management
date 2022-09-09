package zcy.socialpension.services;

import java.util.Map;

/**
 * @author 周晨阳
 * @version 1.0
 */
public interface GetPersonList {
    /**
     * 获取死后仍在领取养老金的人员列表
     *
     * @return 人员列表
     */
    Map<String, Double> getReceiveAfterDeath();
}
