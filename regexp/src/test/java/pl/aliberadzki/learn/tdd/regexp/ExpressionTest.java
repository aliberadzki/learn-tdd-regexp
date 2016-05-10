package pl.aliberadzki.learn.tdd.regexp;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

/**
 * Created by aliberadzki on 09.05.16.
 */
public class ExpressionTest {

    @Test
    public void itFindsAString() {
        Expression expression = Expression.make().find("www");

        assertTrue(expression.match("eeewwwqqq"));
        assertTrue(expression.match("www"));
        assertFalse(expression.match("wwewwrwwt"));
    }
}