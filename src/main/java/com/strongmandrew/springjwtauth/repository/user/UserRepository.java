package com.strongmandrew.springjwtauth.repository.user;

import com.strongmandrew.springjwtauth.entity.User;
import com.strongmandrew.springjwtauth.repository.RootRepository;
import com.strongmandrew.springjwtauth.utils.OperationResult;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends RootRepository {

    OperationResult register(User user);

    Optional<User> getUserByUuid(UUID uuid);
}
