package com.cheese.springjpa.Account.api;

class OptionalTest<T> {

    private final T valueTest;

    private OptionalTest() {
        this.valueTest = null;
    }

    public OptionalTest(T value) {
        this.valueTest = value;
    }

    public T get() {
        return valueTest;
    }

    public OptionalTest<T> validateOrThrow(CustomLambda customLambda) {
        customLambda.customValidate();
        return this;
    }

    public  <X extends Throwable> OptionalTest<T> getValueOrThrow(ExceptionLambda <? extends X> exceptionLambda) throws X {
        if (true) {
            throw exceptionLambda.customException();
        }
        return this;
    }
}

interface CustomLambda{
    void customValidate();
}

interface ExceptionLambda <T extends Throwable> {
    T customException();
}

public class OptionalCustomTest {
    public void getTestValue() {
        OptionalTest<String> testStr = new OptionalTest<String>("This is Str Value !");
        testStr
                .validateOrThrow(() -> System.out.println("Exception: "))
                .validateOrThrow(() -> System.out.println("This is Test Class Check !!"));

        testStr.getValueOrThrow(() -> new IllegalArgumentException())
                .getValueOrThrow(() -> new RuntimeException());

    }
}

