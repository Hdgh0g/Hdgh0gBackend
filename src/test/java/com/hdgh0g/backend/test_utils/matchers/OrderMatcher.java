package com.hdgh0g.backend.test_utils.matchers;

import lombok.RequiredArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OrderMatcher<T> extends TypeSafeMatcher<List<? extends T>> {

    private final Comparator<T> comparator;

    @Override
    protected boolean matchesSafely(List<? extends T> item) {
        return item == null || item.equals(item.stream().sorted(comparator).collect(Collectors.toList()));
    }

    @Override
    public void describeTo(Description description) {

    }

    public static <T> OrderMatcher<T> ordered(Comparator<T> comparator) {
        return new OrderMatcher<>(comparator);
    }

    public static <T> OrderMatcher<T> ordered() {
        return new OrderMatcher<>((Comparator<T>) Comparator.naturalOrder());
    }

    public static <T> OrderMatcher<T> reversed() {
        return new OrderMatcher<>((Comparator<T>) Comparator.naturalOrder().reversed());
    }
}
