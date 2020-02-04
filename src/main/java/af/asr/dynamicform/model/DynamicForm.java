package af.asr.dynamicform.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Map;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class DynamicForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "type", unique = true)
    private String type;

//    @Type(type = "jsonb")
//    @Column(columnDefinition = "jsonb", name = "schema")
    private String schema;

}
