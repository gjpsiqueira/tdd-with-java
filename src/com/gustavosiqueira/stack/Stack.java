package com.gustavosiqueira.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private List<T> values = new ArrayList<T>();

    public void push(T value) {
        values.add(value);
    }

    public T pop()
    {
        return values.remove(values.size() -1 );
    }

    public T peek()
    {
        return values.get(values.size() -1);
    }

    public int size()
    {
        return values.size();
    }

    public boolean isEmpty() {
        return values.size() == 0;
    }
}
