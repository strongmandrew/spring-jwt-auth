package com.strongmandrew.springjwtauth.controller.versioning;

import java.util.function.Predicate;

public interface ControllerPathPrefixConfigurer {

    Predicate<Class<?>> getPredicate();

    String getPrefix();
}
