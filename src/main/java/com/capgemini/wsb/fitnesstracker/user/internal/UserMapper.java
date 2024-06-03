package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
class UserMapper {

    UserDto toDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail());
    }

    User toEntity(UserDto userDto) {
        User user = new User(
                userDto.firstName(),
                userDto.lastName(),
                userDto.birthdate(),
                userDto.email());
        setId(user, userDto.id());
        return user;
    }

    private void setId(User user, Long id) {
        if (id != null) {
            try {
                Field idField = User.class.getDeclaredField("id");
                idField.setAccessible(true);
                idField.set(user, id);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
