package zcy.socialpension.repositoris;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import zcy.socialpension.models.CremationData;

/**
 * @author 周晨阳
 * @version 1.0
 */
@Repository
public interface CremationDataRepository extends Neo4jRepository<CremationData, Long> {
    CremationData findByIdNumber(String idNumber);
}
