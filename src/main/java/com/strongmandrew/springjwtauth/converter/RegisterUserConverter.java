package com.strongmandrew.springjwtauth.converter;

import com.strongmandrew.springjwtauth.entity.RegisterUser;
import com.strongmandrew.springjwtauth.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserConverter {

    private final PasswordEncoder passwordEncoder;

    public User convert(RegisterUser user) {
        var encodedPassword = passwordEncoder.encode(user.password());

        return new User(user.name(), user.email(), encodedPassword);
    }
}
