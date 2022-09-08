package zcy.socialpension.repositoris;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import zcy.socialpension.models.EmployeePerson;

/**
 * @author 周晨阳
 * @version 1.0
 */
@Repository
public interface EmployeePersonRepository extends Neo4jRepository<EmployeePerson, Long> {
}
