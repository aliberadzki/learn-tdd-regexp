# learn-tdd-regexp
Project that was created to learn TDD workflow using Intellij IDEA IDE and jUnit, together with GIT.

Goal is to implement `Expression` class that provides fluent API that matches regular expressions.


Example:

```
Expression expression = Expression.make()
                            .find("foo")
                            .maybe("bar")
                            .then("biz");

boolean test_1 = expression.matches("foobarbiz"); //true
boolean test_2 = expression.matches("foobiz"); //true
boolean test_3 = expression.matches("foobabiz"); //false
```