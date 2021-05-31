package interactive.chat.test.domain.User.controller;

import interactive.chat.test.domain.User.model.User;
import interactive.chat.test.domain.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return new  ResponseEntity<>(userService.register(user), HttpStatus.OK);
    }



}

