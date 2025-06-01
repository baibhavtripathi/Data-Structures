package ai.tribty.misc.interfaceExamples.functional;

import java.util.Arrays;
import java.util.List;

/*
 * 4 type of built-in functional interface
 * 1. Consumer -- takes one arg; no return [void accept(T t)]
 * 2. Predicate -- take one arg; return a boolean result [boolean test(T t)]
 * 3. Function -- take one arg; return object after required processing [R apply(T t)]
 * 4. Supplier -- take no arg; return one arg [T get()]
 */
public class BuiltInImpl {
	public static void main(String[] args) {
        List<String> list = Arrays.asList(
            "Geek", "GeeksQuiz", "g1", "QA", "Geek2");

        // 1. Consumer lambda implementation (x) -> sout(x)
        list.forEach(System.out::println);
        System.out.println();
        list.forEach(x -> System.out.printf(x + " "));
        System.out.println();
        // 2. Predicate - used mainly for filter in stream
        list.stream()
            .filter(x -> x.startsWith("Q"))
            .forEach(x -> System.out.printf(x + " "));
        System.out.println();
        // 3. Function (BinaryOperator) - apply processing on element
        String clubbed_list = list.stream()
            .reduce((a,b) -> a + ", " + b)
            .get();
        System.out.println(clubbed_list);
        // 4. Supplier
        int[] arr = new int[5];
        // Using Supplier functional interface to provide a value
        java.util.function.Supplier<Integer> supplier = () -> 2;
        Arrays.fill(arr, supplier.get());
        System.out.println(Arrays.toString(arr));
    



        System.out.println("Other FunctionalInterface Examples:\n" +
        "1. Runnable [run()], 2. Comparable [compareTo()], 3. ActionListener [action()], 4. Callable [call() throws Exception]");
        System.out.println("Runnable");
        // pre j8
        Runnable r = new Runnable() {
            @Override 
            public void run() {
                System.out.println("Running thread from Runnable");
            }
        };
        Thread t = new Thread(r);
        try {
            t.start();
            t.sleep(100);
            System.out.println("Performing task");
        } catch (Exception e) {
            System.out.println("Eh! Got Error: " + e.getLocalizedMessage());
        }

        // Current way
        Thread thread = new Thread(() -> System.out.println("Running..."));
        try {
            thread.start();
            thread.sleep(100);
            System.out.println("Performing task");
        } catch (Exception e) {
            System.out.println("Eh! Got Error: " + e.getLocalizedMessage());
        }

        
    }
}
