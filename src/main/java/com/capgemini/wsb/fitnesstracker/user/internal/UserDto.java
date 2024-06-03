package com.capgemini.wsb.fitnesstracker.user.internal;

import java.time.LocalDate;

public record UserDto(Long id, String firstName, String lastName, LocalDate birthdate, String email) {}
