package ch12.sec11.exam02;

import java.lang.reflect.*;
	
public class ReflectionExample {
	public static void main(String[] args) throws Exception {
		
		if (args.length != 6) {
			System.out.println("사용법 : java ReflectionExample 클래스 필드명 값 필드명 값 함수명");
			System.exit(0);
		}
		
		Class clazz = Class.forName(args[0]);
//		Car car = new Car();
		//기본생성자 함수 정보
		Constructor constructor = clazz.getDeclaredConstructor();
		//new Car(); 와 같은 동작을 함수로 실행
		Object obj = constructor.newInstance();
		System.out.println(obj);
		
		
		
		Field field = clazz.getDeclaredField(args[1]);
		if (field != null) {
			//car.setModel("현대");
			field.setAccessible(true); //강제로 private 을 Access 가능하도록 설정.
			if (field.getType().equals(int.class)) {
				field.set(obj, Integer.parseInt(args[2]));
			} else {
				field.set(obj, args[2]); //23번쨋 줄 코드 일반화.
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
		
//		Person person = new Person();
		
		
//===============================================================================================
		
//		Class clazz = Car.class; //컴파일때 Car 가 생성되면서 일반화가 안돼서 실무에서는 주로 forName을 사용.
//		
//		System.out.println("[생성자 정보]");
//		Constructor[] constructors = clazz.getDeclaredConstructors();
//		for(Constructor constructor : constructors) {
//			System.out.print(constructor.getName() + "(");
//			Class[] parameters = constructor.getParameterTypes();
//			printParameters(parameters);
//			System.out.println(")");
//		}
//		System.out.println();
//		
//		System.out.println("[필드 정보]");
//		Field[] fields = clazz.getDeclaredFields(); //선언된 필드들을 fields 로 갖고오기.
//		for(Field field : fields) {
//			System.out.println(field.getType().getName() + " " + field.getName());
//		}
//		System.out.println();
//		
//		System.out.println("[메소드 정보]");
//		Method[] methods = clazz.getDeclaredMethods();
//		for(Method method : methods) {
//			System.out.print(method.getName() + "(");
//			Class[] parameters = method.getParameterTypes();
//			printParameters(parameters);
//			System.out.println(")");
//		}
		
//===============================================================================================
	}
			
//	private static void printParameters(Class[] parameters) {
//		for(int i=0; i<parameters.length; i++) {
//			System.out.print(parameters[i].getName());
//			if(i<(parameters.length-1)) {
//				System.out.print(", ");
//			}
//		}
//	}
}		