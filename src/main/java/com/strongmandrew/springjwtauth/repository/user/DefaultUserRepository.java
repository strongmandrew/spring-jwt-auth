package com.strongmandrew.springjwtauth.repository.user;

import com.strongmandrew.springjwtauth.entity.User;
import com.strongmandrew.springjwtauth.repository.mapper.UserRowMapper;
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
    public boolean register(User user) {
        return jdbcClient
                .sql("INSERT INTO USERS VALUES(?, ?, ?, ?)")
                .params(user.getUuid(), user.getName(), user.getEmail(), user.getPassword())
                .update() > 0;
    }

    @Override
    public Optional<User> getUserByUuid(UUID uuid) {
        return jdbcClient
                .sql("SELECT * from USERS WHERE UUID=?")
                .param(uuid)
                .query(new UserRowMapper())
                .optional();
    }
}
