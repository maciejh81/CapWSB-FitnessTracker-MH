package com.capgemini.wsb.fitnesstracker.user.api;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();

    Optional<User> getUser(Long id);

    User createUser(User user);

    void deleteUser(Long id);

    User updateUser(Long id, User user);

    List<User> findByEmailContainingIgnoreCase(String email);

    List<User> findUsersOlderThan(int age);
}
