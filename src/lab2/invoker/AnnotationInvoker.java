package lab2.invoker;

import lab2.annotation.Repeat;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class AnnotationInvoker {
    private static final Map<Class<?>, Object> DEFAULTS = Map.of(
            int.class, 3,
            long.class, 10L,
            double.class, 1.5,
            float.class, 2.5f,
            boolean.class, true,
            char.class, 'a',
            byte.class, (byte) 1,
            short.class, (short) 2,
            String.class, "sector a"
    );

    public void invokeAnnotated(Object target) throws ReflectiveOperationException {
        Method[] methods = target.getClass().getDeclaredMethods();
        Arrays.sort(methods, Comparator.comparing(Method::getName));

        for (Method method : methods) {
            Repeat repeat = method.getAnnotation(Repeat.class);
            int modifiers = method.getModifiers();
            if (repeat == null || !(Modifier.isProtected(modifiers) || Modifier.isPrivate(modifiers))) {
                continue;
            }

            method.setAccessible(true);
            Object[] args = new Object[method.getParameterCount()];
            Class<?>[] types = method.getParameterTypes();
            for (int i = 0; i < args.length; i++) {
                args[i] = valueFor(types[i]);
            }

            System.out.println("invoke " + method.getName() + " x" + repeat.value());
            for (int i = 0; i < repeat.value(); i++) {
                method.invoke(target, args);
            }
        }
    }

    private Object valueFor(Class<?> type) throws ReflectiveOperationException {
        Object value = DEFAULTS.get(type);
        if (value != null) {
            return value;
        }
        return type.getDeclaredConstructor().newInstance();
    }
}
