package com.example.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


class GentlyDownTheStreamTest {

    private GentlyDownTheStream stream;

    @BeforeEach
    void setUp() {

        stream = new GentlyDownTheStream();
    }

    @Test
    void sortedFruits() {

        List<String> expected = stream.fruits.stream()
                                             .sorted()
                                             .collect(Collectors.toList());
        List<String> actual = stream.sortedFruits();

        assertEquals(expected, actual);
    }

    @Test
    void sortedFruitsException() {

        List<String> expected = stream.fruits.stream()
                                             .filter(x -> !x.startsWith("A"))
                                             .sorted()
                                             .collect(Collectors.toList());
        List<String> actual = stream.sortedFruitsException();

        assertEquals(expected, actual);
    }

    @Test
    void sortedFruitsFirstTwo() {

        List<String> expected = stream.fruits.stream()
                                             .sorted()
                                             .limit(2)
                                             .collect(Collectors.toList());
        List<String> actual = stream.sortedFruitsFirstTwo();

        assertEquals(expected, actual);
    }

    @Test
    void commaSeparatedListOfFruits() {

        String expected = stream.fruits.stream()
                                       .sorted()
                                       .collect(Collectors.joining(", "));
        String actual = stream.commaSeparatedListOfFruits();

        assertEquals(expected, actual);
    }

    @Test
    void reverseSortedVeggies() {

        List<String> expected = stream.veggies.stream()
                                              .sorted(Comparator.reverseOrder())
                                              .collect(Collectors.toList());
        List<String> actual = stream.reverseSortedVeggies();

        assertEquals(expected, actual);
    }

    @Test
    void reverseSortedVeggiesInUpperCase() {

        List<String> expected = stream.veggies.stream()
                                              .sorted(Comparator.reverseOrder())
                                              .map(v -> v.toUpperCase(Locale.ROOT))
                                              .collect(Collectors.toList());
        List<String> actual = stream.reverseSortedVeggiesInUpperCase();

        assertEquals(expected, actual);
    }

    @Test
    void topTen() {

        List<Integer> expected = stream.integerValues.stream()
                                                     .sorted(Comparator.reverseOrder())
                                                     .limit(10)
                                                     .collect(Collectors.toList());
        List<Integer> actual = stream.topTen();

        assertEquals(expected, actual);
    }

    @Test
    void topTenUnique() {

        List<Integer> expected = stream.integerValues.stream()
                                                     .sorted(Comparator.reverseOrder())
                                                     .distinct()
                                                     .limit(10)
                                                     .collect(Collectors.toList());
        List<Integer> actual = stream.topTenUnique();

        assertEquals(expected, actual);
    }

    @Test
    void topTenUniqueOdd() {

        List<Integer> expected = stream.integerValues.stream()
                                                     .sorted(Comparator.reverseOrder())
                                                     .distinct()
                                                     .filter(x -> x % 2 != 0)
                                                     .limit(10)
                                                     .collect(Collectors.toList());
        List<Integer> actual = stream.topTenUniqueOdd();

        assertEquals(expected, actual);
    }

    @Test
    void average() {

        Double expected = stream.integerValues.stream()
                                              .mapToInt(i -> i)
                                              .average()
                                              .getAsDouble();
        Double actual = stream.average();

        assertEquals(expected, actual);
    }
}
