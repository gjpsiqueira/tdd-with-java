package com.gustavosiqueira.stack.test;
import com.gustavosiqueira.stack.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void setUp()
    {
        stack = new Stack<Integer>();
    }

    @Test
    public void pushOneValueTo()
    {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void emptyStack()
    {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void pushAndPop()
    {
        stack.push(3);
        stack.push(6);
        stack.push(9);
        Object i = stack.pop();
        assertEquals(i,9);
        assertEquals(stack.size(),2);
    }

    @Test
    public void pushAndPeek()
    {
        stack.push(4);
        stack.push(8);
        stack.push(12);

        stack.peek();
        assertEquals(stack.size(),3);

    }
}
