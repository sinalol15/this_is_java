package ch14.sec09.exam03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
	
public class CallableSubmitExample {
	public static void main(String[] args) {
		//ExecutorService 생성
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		//계산 작업 생성 및 처리 요청 - 익명 클래스를 이용한 코드 구현
		for(int i=1; i<=100; i++) {
			final int idx = i;
			Future<Integer> future = executorService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for(int i=1; i<=idx; i++) {
						sum += i;
					}
					Thread thread = Thread.currentThread();
					System.out.println("[" + thread.getName() + "] 1~" + idx + " 합 계산");
					return sum;
				}
			});

			try {
				int result = future.get(); //병렬처리지만 future 결과를 받아올때까지 기다렸다가 실행되기 때문에 동기화된 코드이다.
				System.out.println("\t리턴값: " + result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//계산 작업 생성 및 처리 요청 - 람다 표현식을 이용한 코드 구현
		for(int i=1; i<=100; i++) {
			final int idx = i;
			Future<Integer> future = executorService.submit(() -> { //병렬처리라 비동기화된 코드이다.(41-49번쨋줄 코드)
				int sum = 0;
				for(int j=1; j<=idx; j++) {
					sum += j;
				}
				Thread thread = Thread.currentThread();
				System.out.println("[" + thread.getName() + "] 1~" + idx + " 합 계산");
				return sum;
			});

			try {
				int result = future.get(); //병렬처리지만 future 결과를 받아올때까지 기다렸다가 실행되기 때문에 동기화된 코드이다.
				System.out.println("\t리턴값: " + result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//ExecutorService 종료
		executorService.shutdown();
	}
}