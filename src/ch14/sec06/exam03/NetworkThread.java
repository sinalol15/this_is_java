package ch14.sec06.exam03;

public class NetworkThread extends Thread {
   private WorkObject workObject;

   public NetworkThread(WorkObject workObject) {
      setName("NetworkThread");
      setDaemon(true);
      this.workObject = workObject;
   }

   @Override
   public void run() {
      for (int i=0;i<5;i++) {
         System.out.println("서버로 부터 파일 수신 중 ...");
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
         }
      }
     
      workObject.setA(10);
      workObject.setB(20);
   }
}