package com.example.expensetracker.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;

public class UserUtils {
    public static User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        return null; // User not authenticated
    }

    public static String getLoggedInUserEmail() {
        User user = getLoggedInUser();
        if (user != null) {
            return user.getUsername();
        }
        return null;
    }
}

