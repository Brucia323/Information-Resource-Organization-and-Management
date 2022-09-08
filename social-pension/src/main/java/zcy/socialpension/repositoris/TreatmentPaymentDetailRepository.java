package zcy.socialpension.repositoris;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import zcy.socialpension.models.TreatmentPaymentDetail;

import java.util.Set;

/**
 * @author 周晨阳
 * @version 1.0
 */
@Repository
public interface TreatmentPaymentDetailRepository extends Neo4jRepository<TreatmentPaymentDetail, Long> {
    Set<TreatmentPaymentDetail> findAllByPersonId(Long personId);
}
