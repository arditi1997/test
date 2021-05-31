package interactive.chat.test.domain.Message.service;

import interactive.chat.test.domain.Message.model.Message;

import java.util.List;

public interface ChatService {

    String sendMessage(Message message, String userId);

    List<Message> listUnreadMessages(String userId);

    String markMessagesAsSeen(String userId, String messageId);

}
