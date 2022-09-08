package zcy.socialpension.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;

/**
 * @author 周晨阳
 * @version 1.0
 */
@Data
@Node
@EqualsAndHashCode(callSuper = true)
public class AgencyPerson extends Person {
    /**
     * 待遇支付明细
     */
    @Relationship(type = "receive", direction = Relationship.Direction.OUTGOING)
    private Set<TreatmentPaymentDetail> treatmentPaymentDetailSet;
}
