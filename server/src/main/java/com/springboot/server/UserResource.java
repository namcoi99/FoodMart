package com.springboot.server;

import com.springboot.server.exception.PasswordNotValidException;
import com.springboot.server.model.AppUser;
import com.springboot.server.service.UserService;
import com.springboot.server.utility.ValidateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AppUser>> getAllUsers() {
        List<AppUser> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable("id") Long id) {
        AppUser user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> registerUser(@RequestBody AppUser user) {
//        Validate password
        if(ValidateUtil.isValid(user.getPassword())) {
//            If password is valid then encode it
            String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
            System.out.println(encodedPassword);
            user.setPassword(encodedPassword);
            AppUser newUser = userService.registerUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
        throw new PasswordNotValidException("This password " + user.getPassword() + " is not valid");
    }

    @PostMapping("/add")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser user) {
        AppUser newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AppUser> updateUser(@RequestBody AppUser user) {
        AppUser updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
