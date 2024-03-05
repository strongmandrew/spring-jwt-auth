package com.strongmandrew.springjwtauth;

import com.strongmandrew.springjwtauth.entity.User;
import com.strongmandrew.springjwtauth.repository.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

@Sql("/init.sql")
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private final User testUser = new User("Test", "Test", "Test");

    @Test
    public void register() {
        Assertions.assertDoesNotThrow(() -> userRepository.register(testUser));

        var userFromStorage = userRepository.getUserByUuid(testUser.getUuid()).orElseThrow();

        Assertions.assertEquals(testUser, userFromStorage);
    }
}
