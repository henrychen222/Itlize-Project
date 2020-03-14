package MultiThreading;
class ThreadPrior12 extends Thread
{
	@Override
	public void run()
	{
		for(int i=1;i<=10;i++)
		System.out.println(" Chaild thread");
		System.out.println(Thread.currentThread().getPriority());
		 System.out.println("running thread name is:"+Thread.currentThread().getName());  
		 System.out.println("running thread priority is:"+Thread.currentThread().getPriority()); 
	}
}
public class ThreadPriorities {

	public static void main(String[] args) {
		//System.out.println(Thread.currentThread().getPriority());	
		//Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
	//	System.out.println(Thread.currentThread().getPriority());	
		//Thread.currentThread().setPriority(1);
		ThreadPrior12 t1=new ThreadPrior12();
		ThreadPrior12 t2=new ThreadPrior12();
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	//	tp89.start();
		//System.out.println(tp2.getPriority());
		/*	for(int i=1;i<=10;i++)
			System.out.println(" Main thread");	*/
	}

}
