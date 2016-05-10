package pl.aliberadzki.learn.tdd.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aliberadzki on 09.05.16.
 */
public class Expression {

    protected String pattern = "";

    public static Expression make() {
        return new Expression();
    }

    public boolean match(String value) {
        String finalPattern = ".*" + this.pattern + ".*";
        Pattern p = Pattern.compile(finalPattern);
        return p.matcher(value).matches();
    }

    public Expression anything() {
        return this.add(".*");
    }

    public Expression maybe(String value) {
        return this.add("(" + this.sanitize(value) +")?");
    }

    public Expression find(String value) {
        return this.add(this.sanitize(value));
    }

    //just an alias
    public Expression then(String value) {
        return this.find(value);
    }

    public String toString() {
        return this.pattern;
    }

    protected String sanitize(String value) {
        return Pattern.quote(value);
    }

    protected Expression add(String value) {
        this.pattern += value;
        return this;
    }
}
