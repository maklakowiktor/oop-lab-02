package lab2;

import lab2.invoker.AnnotationInvoker;
import lab2.model.Robot;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        new AnnotationInvoker().invokeAnnotated(new Robot("r2d2"));
    }
}
