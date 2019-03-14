package de.exxcellent.challenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * The entry class for your solution. This class is only aimed as starting
 * point and not intended as baseline for your implementation.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static final List<Object> EXAMPLE_NESTED_LIST = Collections.unmodifiableList(
            asList(1, asList(2, 3), asList(4, asList(5, 6)))
    );

    public static List<Object> mergeNestedLists(List<Object> list) {
        List<Object> result = new ArrayList<>();

        for (Object item : list) {
            if (item instanceof List){
                result.addAll(mergeNestedLists((List<Object>) item));
            } else {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        List<Integer> result = mergeNestedLists(EXAMPLE_NESTED_LIST)
                .stream()
                .map(a -> (Integer) a)
                .collect(Collectors.toList());

        System.out.print(EXAMPLE_NESTED_LIST);
        System.out.print(" -> ");
        System.out.println(result);
    }
}
