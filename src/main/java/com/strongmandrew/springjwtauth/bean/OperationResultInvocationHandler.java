package com.strongmandrew.springjwtauth.bean;

import com.strongmandrew.springjwtauth.repository.utils.OnFailureMessage;
import com.strongmandrew.springjwtauth.utils.OperationResult;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class OperationResultInvocationHandler implements InvocationHandler {

    private final Object originalBean;

    public OperationResultInvocationHandler(Object originalBean) {
        this.originalBean = originalBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        var methodReturnsOperationResult =
                OperationResult.class.getName().equals(method.getReturnType().getName());

        var originalMethod = originalBean.getClass().getMethod(
                method.getName(),
                method.getParameterTypes()
        );

        var onFailureMessageAnnotation =
                originalMethod.getAnnotation(OnFailureMessage.class);

        if (methodReturnsOperationResult && onFailureMessageAnnotation != null) {
            try {
                return method.invoke(proxy, args);
            } catch (Throwable exception) {
                return OperationResult.of(onFailureMessageAnnotation.value());
            }
        }
        return method.invoke(proxy, args);
    }
}
