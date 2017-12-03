package com.hdgh0g.backend.test_utils;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomTestUtils {

    private RandomTestUtils() {
    }

    public static long randomId() {
        return Math.abs(ThreadLocalRandom.current().nextLong());
    }
}
