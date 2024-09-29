package com.example.weather.request;

import com.example.weather.utils.UserRole;

public record RegisterRequestDTO(
        String login,
        String senha,
        UserRole role
) {
}
