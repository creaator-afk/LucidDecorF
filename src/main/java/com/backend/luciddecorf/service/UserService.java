package com.backend.luciddecorf.service;

import com.backend.luciddecorf.model.User;


public interface UserService {
    User getUserById(long id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    User createUser(User user);
    User updateUser(long id, User user);
    void deleteUser(long id);
}
