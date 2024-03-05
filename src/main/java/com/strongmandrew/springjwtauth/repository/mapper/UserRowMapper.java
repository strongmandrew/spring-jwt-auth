package com.strongmandrew.springjwtauth.repository.mapper;

import com.strongmandrew.springjwtauth.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(@Nullable ResultSet rs, int rowNum) throws SQLException {
        if (rs != null) {
            var uuid = rs.getString(1);
            var name = rs.getString(2);
            var email = rs.getString(3);
            var password = rs.getString(4);

            var createdUser = new User(name, email, password);
            createdUser.setUuid(UUID.fromString(uuid));

            return createdUser;
        } else {
            return User.empty();
        }
    }
}
