package MultiThreading;
class SleepDemo extends Thread
{
	@Override
	public void run()                        
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("child thread");
			
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
		}
	}
}
public class SleepMethodExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SleepDemo sd=new SleepDemo();
		sd.start();
		for(int i=1;i<=10;i++)
		{
			System.out.println("main thread");
		}
		
	}
}
