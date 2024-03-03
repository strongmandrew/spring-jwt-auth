package com.strongmandrew.springjwtauth.repository.user;

import com.strongmandrew.springjwtauth.entity.User;
import com.strongmandrew.springjwtauth.repository.utils.OnFailureMessage;
import com.strongmandrew.springjwtauth.utils.OperationResult;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class DefaultUserRepository implements UserRepository {

    public DefaultUserRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    private final JdbcClient jdbcClient;

    @Override
    @OnFailureMessage("Внутренняя ошибка при регистрации пользователя")
    public OperationResult register(User user) {
        jdbcClient
                .sql("INSERT INTO users VALUES(?, ?, ?)")
                .params(user.getUuid(), user.getName(), user.getEmail())
                .update();
        return OperationResult.empty();
    }

    @Override
    public Optional<User> getUserByUuid(UUID uuid) {
        return jdbcClient
                .sql("SELECT * from users WHERE UUID=?")
                .param(uuid)
                .query(User.class)
                .optional();
    }
}
