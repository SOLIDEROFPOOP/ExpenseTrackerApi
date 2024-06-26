package com.muratkapparov.expensetracker.service;

import com.muratkapparov.expensetracker.entity.User;
import com.muratkapparov.expensetracker.entity.UserModel;

public interface UserService {
    User createUser(UserModel user);

    User read();

    User update(User user);

    void delete();

    User getLoggedInUser();
}
