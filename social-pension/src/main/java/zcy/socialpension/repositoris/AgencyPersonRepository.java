package zcy.socialpension.repositoris;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import zcy.socialpension.models.AgencyPerson;

/**
 * @author 周晨阳
 * @version 1.0
 */
@Repository
public interface AgencyPersonRepository extends Neo4jRepository<AgencyPerson, Long> {
}
