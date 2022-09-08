package zcy.socialpension.models;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDate;

/**
 * @author 周晨阳
 * @version 1.0
 */
@Data
public class Person {
    /**
     * 人员编码
     */
    @Id
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 死亡日期
     */
    private LocalDate deathDate;
    /**
     * 火化数据
     */
    @Relationship(type = "cremation", direction = Relationship.Direction.OUTGOING)
    private CremationData cremationData;
}
