package ai.tribty.array;

import java.util.Iterator;

public class ArrayExecute {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(16);
        System.out.println("Empty array: Length = "+arr.size());
        System.out.println("Array isEmpty? = "+arr.isEmpty());

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        System.out.println("Array Length = "+arr.size());
        System.out.println("Array isEmpty? = "+arr.isEmpty());
        System.out.println("get: "+arr.get(0));
        arr.set(0, 90);
        System.out.println("get: "+arr.get(0));

        System.out.println("Index of: "+ arr.indexOf(90));
        System.out.println("remove: "+ arr.remove(90));
        System.out.println("removeAt: "+ arr.removeAt(3));

        System.out.println("Contains 2? "+ arr.contains(2));
        System.out.println("Iterator");
        Iterator<Integer> itr = arr.iterator();
        while (itr.hasNext()) System.out.println(itr.next());
        arr.clear();
        System.out.println("Empty array: Length = "+arr.size());
        System.out.println("Array isEmpty? = "+arr.isEmpty());

    }
}
