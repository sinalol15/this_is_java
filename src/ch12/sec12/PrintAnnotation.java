package ch12.sec12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) //메소드에서 사용하겠다.
@Retention(RetentionPolicy.RUNTIME) //실행중에만 동작하겠다.
public @interface PrintAnnotation {
	String value() default "-";
	int number() default 15;
}