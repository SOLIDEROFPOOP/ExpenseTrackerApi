package com.muratkapparov.expensetracker.service;

import com.muratkapparov.expensetracker.entity.User;
import com.muratkapparov.expensetracker.entity.UserModel;

public interface UserService {
    User createUser(UserModel user);

    User read(Long id);

    User update(User user , Long id);

    void delete(Long id);

    User getLoggedInUser();
}
