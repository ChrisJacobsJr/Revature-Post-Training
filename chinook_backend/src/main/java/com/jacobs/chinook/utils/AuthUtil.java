package com.jacobs.chinook.utils;

import com.jacobs.chinook.entity.AppUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class AuthUtil {

    /**
     * returns an AppUser object representing the user who is making a given request. This will mostly be used
     * in service classes to identify the requester.
     */
    public AppUser getAuthenticatedUser() {
        // Use spring security to grab the user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        /**
         * 1. checks if authentication is null
         * 2. makes sure the user is an AppUser object
         * 3. casts to AppUser and provides it as "appUser"
         */
        if (authentication == null || !(authentication.getPrincipal() instanceof AppUser appUser)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not authenticated");
        }

        return appUser;
    }
}
