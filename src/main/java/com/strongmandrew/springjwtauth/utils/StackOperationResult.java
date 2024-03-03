package com.strongmandrew.springjwtauth.utils;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class StackOperationResult implements OperationResult {

    private final Stack<String> storage = new Stack<>();

    @Override
    public void push(String value) {
        storage.push(value);
    }

    @Override
    public List<String> getAll() {
        return storage.stream().toList();
    }

    public Optional<String> getLatest() {
        return Optional.ofNullable(storage.peek());
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }
}
