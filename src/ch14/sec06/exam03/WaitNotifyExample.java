package ch14.sec06.exam03;

public class WaitNotifyExample {
   public static void main(String[] args)throws Exception {
      WorkObject workObject = new WorkObject();

      NetworkThread networkThread = new NetworkThread(workObject);
      CalcThread calcThread = new CalcThread(workObject);
      PrintThread printThread = new PrintThread(workObject);
      FileSaveThread fileSaveThread = new FileSaveThread(workObject);

      networkThread.start();
      networkThread.join(); //끝날때까지 기다리기.
     
      //3개 동시에 실행.
      calcThread.start();
      printThread.start();
      fileSaveThread.start();
     
      fileSaveThread.join();
      printThread.join();
     
   }
}