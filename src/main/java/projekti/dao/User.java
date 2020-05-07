
package projekti.dao;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    private String username;
    private String password;
    @Transient
    private String passwordConfirm;
    private String profilename;

    // constructors / standard setters / getters
}
