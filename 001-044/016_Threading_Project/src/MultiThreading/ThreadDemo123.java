package MultiThreading;
class NewThread3 implements Runnable
{
	@Override
	public void run()
	{
	//	for(int i=1;i<=10;i++)
			System.out.println(" Chaild 3 thread");	
	}
}
class NewThread extends Thread
{
	@Override
	public void run()
	{
	//	for(int i=1;i<=10;i++)
			System.out.println(" Chaild thread0");	
	}
}
class NewThread1 extends Thread
{
	@Override
	public void run()
	{
		//for(int i=1;i<=10;i++)
			System.out.println(" Chaild thread1");	
	}
}
public class ThreadDemo123  {
	public static void main(String[] args) throws InterruptedException {
NewThread t=new NewThread();
t.start();
//t.start();
t.join();
NewThread1 t1=new NewThread1();
t1.start();
t1.join();
NewThread3 t3=new NewThread3();
Thread t2=new Thread(t3);
t2.start();
t2.join();


System.out.println(" a main thread");	
	}


}