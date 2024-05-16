package com.muratkapparov.expensetracker.service;

import com.muratkapparov.expensetracker.entity.User;
import com.muratkapparov.expensetracker.entity.UserModel;
import com.muratkapparov.expensetracker.exception.ItemAlreadyExistsException;
import com.muratkapparov.expensetracker.exception.ResourceNotFoundException;
import com.muratkapparov.expensetracker.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(UserModel user) {
        if (userRepository.existsByEmail(user.getEmail())) throw new ItemAlreadyExistsException("User is already registered with this email");
        User newUser = new User();
        BeanUtils.copyProperties(user,  newUser);
        return userRepository.save(newUser);
    }

    @Override
    public User read(Long id) throws ResourceNotFoundException{
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found for the id:" + id));
    }
}
