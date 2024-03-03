package com.strongmandrew.springjwtauth.bean;

import com.strongmandrew.springjwtauth.repository.RootRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class OnFailureMessageBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Object> beforeInitBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (bean instanceof RootRepository) {
            beforeInitBeans.put(beanName, bean);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        var savedBean = beforeInitBeans.get(beanName);

        if (savedBean != null) {
            return Proxy.newProxyInstance(
                    savedBean.getClass().getClassLoader(),
                    savedBean.getClass().getInterfaces(),
                    new OperationResultInvocationHandler(savedBean)
            );
        }

        return bean;
    }
}
