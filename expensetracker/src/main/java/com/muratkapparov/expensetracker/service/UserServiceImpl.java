package com.muratkapparov.expensetracker.service;

import com.muratkapparov.expensetracker.entity.User;
import com.muratkapparov.expensetracker.entity.UserModel;
import com.muratkapparov.expensetracker.exception.ItemAlreadyExistsException;
import com.muratkapparov.expensetracker.exception.ResourceNotFoundException;
import com.muratkapparov.expensetracker.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.KeyStore;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Override
    public User createUser(UserModel user) {
        if (userRepository.existsByEmail(user.getEmail())) throw new ItemAlreadyExistsException("User is already registered with this email");
        User newUser = new User();
        BeanUtils.copyProperties(user,  newUser);
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);
    }

    @Override
    public User read() throws ResourceNotFoundException{
        Long userId = getLoggedInUser().getId();
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found for the id" + userId));
    }

    @Override
    public User update(User user) {
        User oldUser = read();
        oldUser.setName(user.getName() != null ? user.getName() : oldUser.getName());
        oldUser.setEmail(user.getEmail() != null ? user.getEmail() : oldUser.getEmail());
        oldUser.setPassword(user.getPassword() != null ? user.getPassword() : oldUser.getPassword());
        oldUser.setAge(user.getAge() != null ? user.getAge() : oldUser.getAge());
        return userRepository.save(oldUser);
    }

    @Override
    public void delete() {
        User user = read();
        userRepository.delete(user);
    }

    @Override
    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("username not found"));

    }
}
