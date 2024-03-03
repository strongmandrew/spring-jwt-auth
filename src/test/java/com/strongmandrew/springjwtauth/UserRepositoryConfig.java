package com.strongmandrew.springjwtauth;

import com.strongmandrew.springjwtauth.entity.User;
import com.strongmandrew.springjwtauth.repository.user.UserRepository;
import com.strongmandrew.springjwtauth.repository.utils.OnFailureMessage;
import com.strongmandrew.springjwtauth.utils.OperationResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import java.util.Optional;
import java.util.UUID;

@Configuration
public class UserRepositoryConfig {

    @Bean
    @Qualifier("test")
    public UserRepository userRepository() {
        return new UserRepository() {

            @OnFailureMessage("Ошибка при регистрации!")
            @Override
            public OperationResult register(User user) {
                throw new IllegalStateException("Ошибка при регистрации!");
            }

            @Override
            public Optional<User> getUserByUuid(UUID uuid) {
                return Optional.empty();
            }
        };
    }
}
