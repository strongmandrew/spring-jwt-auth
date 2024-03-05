package com.strongmandrew.springjwtauth.entity;

import lombok.*;

import java.util.UUID;

@EqualsAndHashCode
@Getter
@RequiredArgsConstructor
public class User {

    @NonNull
    @Setter
    private UUID uuid = UUID.randomUUID();

    private final String name;

    private final String email;

    @NonNull
    @EqualsAndHashCode.Exclude
    @Setter
    private String password;

    public static User empty() {
        return new User("", "", "");
    }
}
