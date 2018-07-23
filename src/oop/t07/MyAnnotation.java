package oop.t07;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MyAnnotation {
    String type() default "atomic";
}
