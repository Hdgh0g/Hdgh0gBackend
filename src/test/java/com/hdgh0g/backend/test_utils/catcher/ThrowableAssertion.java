package com.hdgh0g.backend.test_utils.catcher;


import org.hamcrest.Matchers;
import org.junit.Assert;

public class ThrowableAssertion {

    public static ThrowableAssertion assertThrown(ExceptionThrower exceptionThrower) {
        try {
            exceptionThrower.throwException();
        } catch (Throwable caught) {
            return new ThrowableAssertion(caught);
        }
        throw new ExceptionNotThrownAssertionError();
    }

    private final Throwable caught;

    private ThrowableAssertion(Throwable caught) {
        this.caught = caught;
    }

    public ThrowableAssertion isInstanceOf(Class<? extends Throwable> exceptionClass) {
        Assert.assertThat(caught, Matchers.instanceOf(exceptionClass));
        return this;
    }

    public ThrowableAssertion hasMessage(String expectedMessage) {
        Assert.assertThat(caught.getMessage(), Matchers.equalTo(expectedMessage));
        return this;
    }
}
