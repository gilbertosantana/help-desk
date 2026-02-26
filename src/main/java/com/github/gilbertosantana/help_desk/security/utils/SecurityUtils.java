package com.github.gilbertosantana.help_desk.security.utils;

import com.github.gilbertosantana.help_desk.entities.User;
import com.github.gilbertosantana.help_desk.security.JWTUserData;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

public class SecurityUtils {

    public static JWTUserData getCurrentUser() throws AccessDeniedException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || !(authentication.getPrincipal() instanceof JWTUserData)){
            throw new AccessDeniedException("Usuário não autenticado");
        }
        return (JWTUserData) authentication.getPrincipal();

    }
}
