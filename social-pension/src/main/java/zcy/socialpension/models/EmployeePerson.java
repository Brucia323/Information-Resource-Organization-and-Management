package zcy.socialpension.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author 周晨阳
 * @version 1.0
 */
@Node
@Data
@EqualsAndHashCode(callSuper = true)
public class EmployeePerson extends Person {
    /**
     * 个人账户余额
     */
    private String personalAccountBalance;
}
