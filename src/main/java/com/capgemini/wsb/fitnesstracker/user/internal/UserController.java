package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    public UserController(UserServiceImpl userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public User addUser(@RequestBody UserDto userDto) {
        User newUser = userMapper.toEntity(userDto);
        return userService.createUser(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User updatedUser = userMapper.toEntity(userDto);
        updatedUser = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(userMapper.toDto(updatedUser));
    }

    @GetMapping("/searchByEmail")
    public ResponseEntity<List<UserDto>> searchByEmail(@RequestParam String email) {
        List<User> users = userService.findByEmailContainingIgnoreCase(email);
        return ResponseEntity.ok(users.stream().map(userMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/searchByAge")
    public ResponseEntity<List<UserDto>> searchByAge(@RequestParam int age) {
        List<User> users = userService.findUsersOlderThan(age);
        return ResponseEntity.ok(users.stream().map(userMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        User user = userService.getUser(id).orElseThrow(() -> new UserNotFoundException(id));
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
