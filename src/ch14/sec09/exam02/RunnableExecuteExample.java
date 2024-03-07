package ch14.sec09.exam02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecuteExample {

	public static void main(String[] args) {
		//1000개의 메일 생성
		String[][] mails = new String[1000][3];
		for(int i=0; i<mails.length; i++) {
			mails[i][0] = "admin@my.com";
			mails[i][1] = "member"+i+"@my.com";
			mails[i][2] = "신상품 입고";
		}
		
		//ExecutorService 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		//앞에서 학습한 일반 스레드
		//1000초 시간
		for(int i=0; i<1000; i++) {
			final int idx = i;
			new Thread(() -> { //스레드가 1000개가 생겨 많은 데이터 용량을 차지한다.
				String from = mails[idx][0];
				String to = mails[idx][1];
				String content = mails[idx][2];
				//mail 발송하는 부분 --> network, cpu 시간 사용안됨.
				//실행 시간 1초
				System.out.println("[메일 발송] " + from + " ==> " + to + ": " + content);
			}).start();
		}
		
		//이메일을 보내는 작업 생성 및 처리 요청
		for(int i=0; i<1000; i++) {
			final int idx = i;
			executorService.execute(new Runnable() { //5개의 스레드로 나누어 처리돼서 200초가 걸린다.
				@Override
				public void run() {
					Thread thread = Thread.currentThread();
					String from = mails[idx][0];
					String to = mails[idx][1];
					String content = mails[idx][2];
					//mail 발송하는 부분 --> network, cpu 시간 사용안됨.
					//실행 시간 1초
					System.out.println("[" + thread.getName() + "] " + from + " ==> " + to + ": " + content);
				}
			});
		}
		
		//이메일을 보내는 작업 생성 및 처리 요청
		for(int i=0; i<1000; i++) {
			final int idx = i;
			executorService.execute(() -> { 
				//얾매여있지 않아 결과를 기다리지 않고 코드를 실행하는 "비동기화"된 코드이다.(여러개 한번에 실행 가능)
				//결과는 언제 추출할 지 모름. 순서도 모름. -비동기-
				Thread thread = Thread.currentThread();
				String from = mails[idx][0];
				String to = mails[idx][1];
				String content = mails[idx][2];
				//mail 발송하는 부분 --> network, cpu 시간 사용안됨.
				//실행 시간 1초
				System.out.println("[" + thread.getName() + "] " + from + " ==> " + to + ": " + content);
			});
		}
			
		//ExecutorService 종료
		executorService.shutdown();
	}
}