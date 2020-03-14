package MultiThreading;
class ThreadA extends Thread
{
	public void run()
	{
		System.out.println("from thread a");
		/*try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
class ThreadB extends Thread
{
	
	public void run()
	{
		System.out.println("from thread b");
	}
}class ThreadC extends Thread
{
	public void run()
	{
		System.out.println("from thread c");
	}
}
class ThreadD extends Thread
{
	public void run()
	{
		System.out.println("from thread d");
	}
}class ThreadE extends Thread
{
	public void run()
	{
		System.out.println("from thread e");
	}
}
public class ThreadJoinedExamples {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
ThreadA a =new ThreadA();
ThreadB b=new ThreadB();
ThreadC c=new ThreadC();
ThreadD d=new ThreadD();
ThreadE e=new ThreadE();
a.start();
b.start();
c.start();
d.start();
e.start();
a.join();
b.join();
c.join();
e.join();
d.join();
System.out.println("its a main thread");
	}

}
