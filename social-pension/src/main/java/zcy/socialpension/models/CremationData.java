package zcy.socialpension.models;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDate;

/**
 * @author 周晨阳
 * @version 1.0
 */
@Data
@Node
public class CremationData {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 死者姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String idNumber;
    /**
     * 火化时间
     */
    private LocalDate cremationTime;
}
