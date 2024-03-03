package com.strongmandrew.springjwtauth;

import com.strongmandrew.springjwtauth.entity.User;
import com.strongmandrew.springjwtauth.repository.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OnFailureMessageBeanPostProcessorTest {

    @Autowired
    @Qualifier("test")
    private UserRepository userRepository;

    @Test
    public void onFailure() {
        var throwableMessage = "Ошибка при регистрации!";

        var operationResult = userRepository.register(noneUser());

        var operationResultMessage = operationResult.getAll().stream().findFirst().orElse("");

        Assertions.assertEquals(throwableMessage, operationResultMessage);
    }

    private static User noneUser() {
        return new User("Joe", "Joe");
    }
}
