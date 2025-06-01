package ai.tribty.misc.interfaceExamples.functional;

@FunctionalInterface
interface FunctionalInterfaceExample {
    // SAM - Single Interface Method
    void cry();
    
    // For backward compatibility
    default String sayIt() {
        return "This is default method...";
    }

    // For Utility and helper function, can be called directly using Interface name; implementation not needed
    public static void Khandan() {
        System.out.println("Bade baap ki aulad.");
    }
}

public class FunctionalInterfaceImpl {
    public static void main(String[] args) {
        FunctionalInterfaceExample.Khandan();
        FunctionalInterfaceExample obj = new FunctionalInterfaceExample() {
            @Override
            public void cry() {
                System.out.println("look who is crying...👻");
            }
        };
        obj.cry();
        InterfaceImplementer imp = new InterfaceImplementer();
        imp.cry();
    }
}

class InterfaceImplementer implements FunctionalInterfaceExample {
    @Override
    public void cry() {
        System.out.println("Crying in implementation...");
    }
}