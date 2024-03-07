package ch14.sec06.exam03;

public class FileSaveThread extends Thread {
   private WorkObject workObject;

   public FileSaveThread(WorkObject workObject) {
      setName("FileSaveThread");
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
      System.out.println("파일 저장 작업");
   }
}