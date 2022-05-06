package springserver.service;

import org.springframework.data.jpa.repository.JpaRepository;
import springserver.model.User;
import springserver.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService extends GenericCrudServiceImpl<User,Long> {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

}
