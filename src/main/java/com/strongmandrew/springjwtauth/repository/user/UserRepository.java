package com.strongmandrew.springjwtauth.repository.user;

import com.strongmandrew.springjwtauth.entity.User;
import com.strongmandrew.springjwtauth.repository.RootRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends RootRepository {

    boolean createUser(User user);

    Optional<User> getUserByUuid(UUID uuid);
}
