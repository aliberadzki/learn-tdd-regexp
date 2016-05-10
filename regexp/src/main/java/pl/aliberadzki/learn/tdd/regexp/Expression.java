package pl.aliberadzki.learn.tdd.regexp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aliberadzki on 09.05.16.
 */
public class Expression {

    protected String pattern = "";
    private static final String[] NO_MATCHES = {};

    public static Expression make() {
        return new Expression();
    }

    public boolean matches(String value) {
        Pattern p = this.finalizePattern();
        return p.matcher(value).matches();
    }

    public String[] match(String value) {
        Pattern p = this.finalizePattern();
        Matcher matcher = p.matcher(value);
        ArrayList<String> matches = new ArrayList<>();

        while(matcher.find()) {
            matches.add(matcher.group(1));
        }

        return matches.toArray(NO_MATCHES);
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

    protected Pattern finalizePattern() {
        String finalPattern = ".*(" + this.pattern + ").*";
        return Pattern.compile(finalPattern);
    }
}
