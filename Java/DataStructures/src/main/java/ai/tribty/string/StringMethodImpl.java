package ai.tribty.string;

import java.util.Arrays;

public class StringMethodImpl {
    public static void main(String[] args) {
        // Literal - String Pool
        String str = "Harry Potter";
        // Constructor - Heap
        String s = new String("The pursuit of happiness");

        /*
         * String is - Immutable, thread-safe, fast and high memory efficiency
         * StringBuilder - Mutable, NOT thread-safe, fast and memory efficient
         * StringBuffer - Mutable, thread-safe, slow and less memory efficient
         */

        StringBuilder stringBuilder = new StringBuilder(str);
        StringBuffer stringBuffer = new StringBuffer(s);
        long startInstance = System.nanoTime();
        stringBuilder.append(" IMBD Rating: 9.4");
        long endInstance = System.nanoTime();
        System.out.println("StringBuilder took : " + (endInstance-startInstance));

        startInstance = System.nanoTime();
        stringBuffer.append(" IMBD Rating: 9.6");
        endInstance = System.nanoTime();
        System.out.println("StringBuffer took : " + (endInstance-startInstance));

        /*
         * Output
         * Significant difference
         * StringBuilder took : 8900 ns
         * StringBuffer took : 29300 ns
         */

        // String Methods

        System.out.println("length() : " + str.length());
        System.out.println("charAt() : " + s.charAt(0));
        System.out.println("substring() : " + s.substring(3));
        System.out.println("substring() i-j-1 : " + s.substring(2, 5));
        System.out.println("concat() : " + s.concat(" Best"));
        System.out.println("indexOf() : " + s.indexOf("Best"));
        System.out.println("indexOf(str, i) : " + s.indexOf("p", 5));
        System.out.println("lastIndexOf() : " + s.lastIndexOf("p"));
        System.out.println("equal() & toLowerCase() : " + s.equals(s.toLowerCase()));
        System.out.println("equalIgnoreCase() & toUpperCase() : " + s.equalsIgnoreCase(s.toUpperCase()));
        stringBuilder.append("  ");
        System.out.println(stringBuilder.toString());
        System.out.println("trim() : " + (stringBuilder.toString()).trim());
        System.out.println("replace() : " + str.replace('r', 's'));
        System.out.println("contains() : " + str.contains("ss"));
        System.out.println("toCharArray() : " + Arrays.toString(str.toCharArray()));
        System.out.println("startsWith() : " + str.startsWith("Ha"));
        System.out.println("endsWith() : " + s.endsWith("ss"));
        System.out.println("repeat() : " + "Hello ".repeat(10));
    }
}
