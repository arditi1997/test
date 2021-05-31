package interactive.chat.test.domain.User.repository;

import interactive.chat.test.domain.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByNickname(String nickname );
}
