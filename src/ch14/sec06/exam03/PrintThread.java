package ch14.sec06.exam03;

public class PrintThread extends Thread {
   private WorkObject workObject;

   public PrintThread(WorkObject workObject) {
      setName("PrintThread");
      setDaemon(true);
      this.workObject = workObject;
   }

   @Override
   public void run() {
      synchronized(workObject) {
         try {
            workObject.wait();
         } catch (InterruptedException e) {
         }
      }
      for (int i=0;i<5;i++) {
         System.out.println("프린트 작업");
      }
   }
}