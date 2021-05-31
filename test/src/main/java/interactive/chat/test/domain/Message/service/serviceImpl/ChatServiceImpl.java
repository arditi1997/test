package interactive.chat.test.domain.Message.service.serviceImpl;

import interactive.chat.test.domain.Message.model.Message;
import interactive.chat.test.domain.Message.repository.MessageRepository;
import interactive.chat.test.domain.Message.service.ChatService;
import interactive.chat.test.domain.User.model.User;
import interactive.chat.test.domain.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final MessageRepository messageRepository;

    private final UserRepository userRepository;

    @Override
    public String sendMessage(Message message, String userId) {
        User checkUser =  userRepository.findById(userId).orElse(null);
        if( checkUser != null){
            message.setUserId(userId);
            message.setStatus("UNREAD");
            messageRepository.save(message);
            return "Message sent succesfully!";
        }else{
            return "User not found";
        }

    }

    @Override
    public List<Message> listUnreadMessages(String userId) {
        List<Message> messageList = messageRepository.findByUserIdAndStatus(userId, "UNREAD");
        return messageList;
    }

    @Override
    public String markMessagesAsSeen(String userId, String messageId) {
        Message message = messageRepository.findByIdAndUserId(messageId, userId).orElse(null);
        if(message !=null){
            message.setStatus("SEEN");
            messageRepository.save(message);
            return "Message: seen";
        }else{
            return "Message id or user id not found";
        }

    }
}
