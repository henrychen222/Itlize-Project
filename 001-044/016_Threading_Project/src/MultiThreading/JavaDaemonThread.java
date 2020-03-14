package MultiThreading;

public class JavaDaemonThread {
	 
    public static void main(String[] args) throws InterruptedException {
        Thread dt = new Thread(new DaemonThread(), "dt");
        dt.setDaemon(true);
        dt.start();
        //continue program
        Thread.sleep(6000);
        System.out.println("Finishing program");
    }
 
}
 
class DaemonThread implements Runnable {
 
    @Override
    public void run() {
        while(true){
            processSomething();
        }
    }
 
    private void processSomething() {
        try {
            System.out.println("Processing daemon thread");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     
}