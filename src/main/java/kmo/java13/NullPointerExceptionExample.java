package kmo.java13;

import java.util.ArrayList;
import java.util.stream.Stream;

public class NullPointerExceptionExample {

    private static final String field = null;

    public static void main(String[] args) {
        final Integer one = 1;
        final Integer two = 2;
        final Integer three = null;
        final LevelOne levelOne = () -> null;
        final LevelOne levelOneWithNPE = null;
        final LevelTwo levelTwo = () -> null;
        final LevelTwo levelThreeWithNPEInMethod = () -> (LevelThree) () -> {
            final String string = null;
            string.toString();
        };

        tryAndLog(() -> {
            final var i = one + two + three;
        });
        tryAndLog(() -> levelOneWithNPE.doSomething());
        tryAndLog(() -> levelOne.doSomething().doSomething());
        tryAndLog(() -> levelTwo.doSomething().doSomething());
        tryAndLog(() -> levelThreeWithNPEInMethod.doSomething().doSomething());
        tryAndLog(() -> field.substring(1));
        tryAndLog(() -> new ArrayList<>(null));
        tryAndLog(() -> Stream.of(levelOneWithNPE).forEach(LevelOne::doSomething));
    }

    interface LevelOne {
        LevelTwo doSomething();
    }

    interface LevelTwo {
        LevelThree doSomething();
    }

    interface LevelThree {
        void doSomething();
    }

    public static void tryAndLog(final Runnable runnable) {
        try {
            runnable.run();
        } catch (final RuntimeException e) {
            e.printStackTrace();
        }
    }
}
