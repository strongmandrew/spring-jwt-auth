package com.strongmandrew.springjwtauth.entity;

import lombok.*;

import java.util.UUID;

@EqualsAndHashCode
@Getter
@RequiredArgsConstructor
public class User {

    private final UUID uuid = UUID.randomUUID();

    private final String name;

    private final String email;

    private String password;
}
