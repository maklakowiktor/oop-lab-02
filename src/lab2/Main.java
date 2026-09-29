package lab2;

import lab2.invoker.AnnotationInvoker;
import lab2.model.Drone;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        new AnnotationInvoker().invokeAnnotated(new Drone("falcon"));
    }
}
