package com.gustavosiqueira.camelcase.test;
import java.util.List;
import com.gustavosiqueira.camelcase.CamelCase;
import com.gustavosiqueira.camelcase.CamelCaseException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class TestCamelCase {

    @Test
    public void shouldThrowExceptionWhenEmpty() throws CamelCaseException {
        CamelCaseException exception = assertThrows(CamelCaseException.class, () -> CamelCase.convertCamelCase(""));
        assertTrue(exception.getMessage().contains("empty or null"));
    }

    @Test
    public void shouldThrowExceptionWhenNull() throws CamelCaseException {
        CamelCaseException exception = assertThrows(CamelCaseException.class, () -> CamelCase.convertCamelCase(null));
        assertTrue(exception.getMessage().contains("empty or null"));
    }

    @Test
    public void shouldThrowExceptionWhenStartNumbers() throws CamelCaseException {

        CamelCaseException exception = assertThrows(CamelCaseException.class, () -> CamelCase.convertCamelCase("10Numbers"));
        assertTrue(exception.getMessage().contains("numbers"));
    }

    @Test
    public void shouldThrowExceptionWhenSpecialCharacter() throws CamelCaseException {
        CamelCaseException exception = assertThrows(CamelCaseException.class, () -> CamelCase.convertCamelCase("name#test"));
        assertTrue(exception.getMessage().contains("special character"));
    }

    @Test
    public void shouldBeCamelCase() throws CamelCaseException {

        assertArrayEquals(new String[] {"nome"} , CamelCase.convertCamelCase("nome").toArray());
        assertArrayEquals(new String[] {"nome","composto"} , CamelCase.convertCamelCase("nomeComposto").toArray());
        assertArrayEquals(new String[] {"nome","composto"} , CamelCase.convertCamelCase("NomeComposto").toArray());
        assertArrayEquals(new String[] {"CPF"} , CamelCase.convertCamelCase("CPF").toArray());
        assertArrayEquals(new String[] {"numero", "CPF", "contribuinte"} , CamelCase.convertCamelCase("numeroCPFContribuinte").toArray());

    }
}
