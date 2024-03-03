package com.strongmandrew.springjwtauth.utils;

import java.util.List;

public interface OperationResult {

    static <T> OperationResult empty() {
        return new StackOperationResult();
    }

    static <T> OperationResult of(String value) {
        OperationResult operationResult = new StackOperationResult();

        operationResult.push(value);

        return operationResult;
    }

    void push(String value);

    List<String> getAll();

    boolean isEmpty();
}
