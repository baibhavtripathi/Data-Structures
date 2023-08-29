package ai.tribty.array;

import java.util.Iterator;

public class ArrayExecute {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        System.out.println("Array Length = "+arr.size());
        System.out.println("Array isEmpty? = "+arr.isEmpty());

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        System.out.println("Array Length = "+arr.size());
        System.out.println("Array isEmpty? = "+arr.isEmpty());
        System.out.println(arr);
        arr.insertAt(13, 344);
        System.out.println(arr);
        System.out.println("get at 0 index: "+arr.get(0));
        arr.set(0, 90);
        System.out.println("get at 0 index: "+arr.get(0));

        System.out.println("Index of: "+ arr.indexOf(90));
        System.out.println("remove: "+ arr.remove(90));
        System.out.println("removeAt: "+ arr.removeAt(3));
        System.out.println(arr);

        System.out.println("Contains 2? "+ arr.contains(2));
        System.out.println("Iterator");
        Iterator<Integer> itr = arr.iterator();
        while (itr.hasNext()) System.out.print(itr.next()+", ");
        System.out.println();
        arr.clear();
        System.out.println("Array Length = "+arr.size());
        System.out.println("Array isEmpty? = "+arr.isEmpty());

    }
}
