
package projekti.dao;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User extends AbstractPersistable<Long> {
    private String name;
    private String uname;
    private String password;
    private String profilename;
     
    // constructors / standard setters / getters
}
