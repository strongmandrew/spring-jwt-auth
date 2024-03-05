package com.strongmandrew.springjwtauth.controller.versioning.v1;

import com.strongmandrew.springjwtauth.controller.versioning.ControllerPathPrefixConfigurer;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class VersionConfigurerV1 implements ControllerPathPrefixConfigurer {

    @Override
    public Predicate<Class<?>> getPredicate() {
        return (clazz) -> clazz.isAnnotationPresent(ApiV1.class);
    }

    @Override
    public String getPrefix() {
        return "/api/v1";
    }
}
