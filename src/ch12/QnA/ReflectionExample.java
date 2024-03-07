package ch12.QnA;

import java.lang.reflect.*;

public class ReflectionExample {

	public static void main(String[] args) throws Exception {
		if (args.length != 6) {
			System.out.println("사용법 : java ReflectionExample 클래스 필드명 값 필드명 값 함수명");
			System.exit(0);
		}
		
		Class clazz = Class.forName(args[0]);
		Constructor constructor = clazz.getDeclaredConstructor();
		Object obj = constructor.newInstance();
		System.out.println(obj);
		
		Field field = clazz.getDeclaredField(args[1]);
		if (field != null) {
			field.setAccessible(true);
			if (field.getType().equals(int.class)) {
				field.set(obj, Integer.parseInt(args[2]));
			} else {
				field.set(obj, args[2]);
			}
		}
		System.out.println(obj);
		
		Field field2 = clazz.getDeclaredField(args[3]);
		if (field2 != null) {
			field2.setAccessible(true);
			if (field2.getType().equals(int.class)) {
				field2.set(obj, Integer.parseInt(args[4]));
			} else {
				field2.set(obj, args[4]);
			}
		}
		System.out.println(obj);
		
		try {
			Method method = clazz.getDeclaredMethod(args[5]);
			if (method != null) {
				method.invoke(obj);
			}
		} catch(NoSuchMethodException e) {
			System.out.println(args[5] + "() 메소드가 존재하지 않습니다.");
		}
	}

}
