package pl.aliberadzki.learn.tdd.regexp;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.lang.reflect.Array;

/**
 * Created by aliberadzki on 09.05.16.
 */
public class ExpressionTest {

    @Test
    public void itFindsAString() {
        Expression expression = Expression.make().find("www");

        assertTrue(expression.matches("eeewwwqqq"));
        assertTrue(expression.matches("www"));
        assertFalse(expression.matches("wwewwrwwt"));
    }

    @Test
    public void itChecksForAnything() {
        Expression expression = Expression.make().anything();
        assertTrue(expression.matches("foo"));

    }

    @Test
    public void itMaybeHasAValue() {
        Expression expression = Expression.make().maybe("http");
        assertTrue(expression.matches("http"));
    }

    @Test
    public void itCanChainMethods() {
        Expression expression = Expression.make().find("foo").maybe("bar").then("biz");
        assertTrue(expression.matches("ooofoobarbiz"));
        assertTrue(expression.matches("eeefoobiz"));
        assertFalse(expression.matches("foobabiz"));

        expression = Expression.make().find("www").maybe(".").then("google");
        assertTrue(expression.matches("www.google"));
        assertTrue(expression.matches("wwwgoogle"));
        assertFalse(expression.matches("www#google"));
    }

    @Test
    public void itFindsMatchingGroups() {
        Expression expression = Expression.make().find("dupa");

        String[] matches = expression.match("alalaladupaioioio");

        assertTrue(matches.length > 0);
        assertEquals("test msg","dupa", matches[0]);
    }
}