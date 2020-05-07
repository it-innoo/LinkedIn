
package projekti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projekti.dao.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
