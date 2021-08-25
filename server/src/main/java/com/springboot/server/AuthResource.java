package com.springboot.server;

import com.springboot.server.model.AppResponseData;
import com.springboot.server.model.AppUser;
import com.springboot.server.model.AppLoginForm;
import com.springboot.server.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthResource {
    private final UserService userService;

    public AuthResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<AppResponseData> login(@RequestBody AppLoginForm loginForm) {
        AppUser findUser = userService.findUserByUsername(loginForm.getUsername());
        if (null == findUser || !new BCryptPasswordEncoder().matches(loginForm.getPassword(), findUser.getPassword())) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        AppResponseData response = new AppResponseData(findUser.getUsername(), findUser.getEmail());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
