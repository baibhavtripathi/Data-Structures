package ai.tribty.misc.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamImpl {
    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("Reflection", "Collection", "Stream"),
            Arrays.asList("Structure", "State", "Flow"),
            Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
        );

        // Set to hold listOfLists unique values
        Set<String> setOfListElements = new HashSet<>();

        // Create Stream and process
        List<String> results = listOfLists.stream()
            .flatMap(List::stream)
            .filter(x -> x.startsWith("S"))
            .map(String::toUpperCase)
            .distinct()
            .sorted()
            .peek(s -> setOfListElements.add(s))
            .collect(Collectors.toList());

        // Print setOfListElements
        setOfListElements.stream().forEach(System.out::println);

        // Print result
        results.stream().forEach(System.out::println);

        // Terminal operations
        List<String> names = Arrays.asList(
            "Reflection", "Collection", "Stream",
            "Structure", "Sorting", "State", "Ria", "Rin"
        );
        System.out.println("\nPrinting only names startsWith 'S'");
        names.stream()
            .filter(s -> s.startsWith("S"))
            .forEach(System.out::println);
        
        String allNames = names.stream()
            .reduce("", (a, b) -> a + ", " + b);
        System.out.println("\nReduce: " + allNames);

        System.out.println("\nWith Optional , ::");
        Optional<String> allNamesOptional = names.stream()
            .reduce((a, b) -> a + ", " + b);
        allNamesOptional.stream().forEach(System.out::println);
        
        System.out.print("Numbers of names starting with 'R': ");
        long namesStartsWithR = names.stream()
            .filter(x -> x.startsWith("R"))
            .count();
        System.out.println(namesStartsWithR);
        System.out.println("First name with 'R': " + names.stream().filter(x -> x.startsWith("R")).findFirst().get());
        
        boolean allNamesStartsWithR = names.stream()
        .allMatch(x -> x.startsWith("R"));
        System.out.println("All names with 'R'? " + allNamesStartsWithR); 
    }
}
