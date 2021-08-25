package com.springboot.server.service;
import com.springboot.server.exception.UserNotFoundException;
import com.springboot.server.model.AppUser;
import com.springboot.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.Collections.emptyList;

@Service
@Transactional
//public class UserService implements UserDetailsService {
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AppUser addUser(AppUser user) {
        return userRepository.save(user);
    }

    public AppUser registerUser(AppUser user) {
        return userRepository.save(user);
    }

    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }

    public AppUser updateUser(AppUser user) {
        return userRepository.save(user);
    }

    public AppUser findUserById(Long id) {
        return userRepository.findUserByUserID(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found."));
    }

    public void deleteUser(Long id) {
        userRepository.deleteUserByUserID(id);
    }

    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        AppUser user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new User(user.getUsername(), user.getPassword(), emptyList());
//    }
}
