package ai.tribty.misc;

class ReferredClass {
   void print() {
        System.out.println("Printing from reference...");
   }

   @Override
   protected void finalize() throws Throwable {
       System.out.println("Ready to fall into the void!");
   }
}

public class ObjectLifeCycle {
    public static void main(String[] args) throws Throwable {
        ReferredClass ref = new ReferredClass();
        ref.print();
    }
}
