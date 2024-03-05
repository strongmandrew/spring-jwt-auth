package com.strongmandrew.springjwtauth.config;

import com.strongmandrew.springjwtauth.controller.versioning.ControllerPathPrefixConfigurer;
import io.micrometer.common.lang.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ControllerMappingConfig implements WebMvcConfigurer {

    private final List<ControllerPathPrefixConfigurer> pathPrefixConfigurers;

    @Override
    public void configurePathMatch(@Nullable PathMatchConfigurer configurer) {
        if (configurer != null) {
            pathPrefixConfigurers.forEach((pathConfigurer) -> {
                configurer.addPathPrefix(pathConfigurer.getPrefix(), pathConfigurer.getPredicate());
            });
        }
    }
}
