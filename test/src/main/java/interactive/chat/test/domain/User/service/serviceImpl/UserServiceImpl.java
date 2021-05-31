package interactive.chat.test.domain.User.service.serviceImpl;

import interactive.chat.test.domain.User.model.User;
import interactive.chat.test.domain.User.repository.UserRepository;
import interactive.chat.test.domain.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String register(User user) {
       User checkUser =  userRepository.findByNickname(user.getNickname()).orElse(null);
       if(checkUser == null) {
           userRepository.save(user);
           return user.getId();
       }else{
           return "Nickname is used before!";
       }
    }
}
