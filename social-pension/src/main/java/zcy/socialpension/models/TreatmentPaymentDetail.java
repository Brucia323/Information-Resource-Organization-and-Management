package zcy.socialpension.models;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author 周晨阳
 * @version 1.0
 */
@Node
@Data
public class TreatmentPaymentDetail {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 人员编码
     */
    private Long personId;
    /**
     * 结算年月
     */
    private String billingYear;
    /**
     * 待遇年月
     */
    private String treatmentDate;
    /**
     * 待遇项目代码
     */
    private String treatmentCode;
    /**
     * 待遇金额
     */
    private String treatmentAmount;
}
