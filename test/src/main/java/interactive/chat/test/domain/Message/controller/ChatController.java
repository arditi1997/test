package interactive.chat.test.domain.Message.controller;

import interactive.chat.test.domain.Message.model.Message;
import interactive.chat.test.domain.Message.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    //list
    @GetMapping("/list-all-unread-messages")
    public ResponseEntity<?> listUnreadMessages( @RequestParam("userId") String userId) {
        return new ResponseEntity<>(chatService.listUnreadMessages(userId), HttpStatus.OK);
    }

    //mark
    @PostMapping("/mark-messages-seen")
    public ResponseEntity<?> markMessagesAsSeen(@RequestParam("userId") String userId, @RequestParam("messageId") String messageId) {
        return new ResponseEntity<>(chatService.markMessagesAsSeen(userId, messageId), HttpStatus.OK);
    }

    @PostMapping("/send-message")
    public ResponseEntity<?> sendMessage(@RequestBody Message message, @RequestParam("userId") String userId) {
       return new ResponseEntity<>(chatService.sendMessage(message, userId), HttpStatus.OK);
    }
}