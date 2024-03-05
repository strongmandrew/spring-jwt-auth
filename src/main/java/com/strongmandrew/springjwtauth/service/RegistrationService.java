package com.strongmandrew.springjwtauth.service;

import com.strongmandrew.springjwtauth.converter.RegisterUserConverter;
import com.strongmandrew.springjwtauth.entity.RegisterUser;
import com.strongmandrew.springjwtauth.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final RegisterUserConverter userConverter;

    public boolean register(RegisterUser user) {
        var convertedUser = userConverter.convert(user);
        return userRepository.createUser(convertedUser);
    }
}
