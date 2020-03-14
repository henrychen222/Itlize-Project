package MultiThreading;
class MyJoinedThread extends Thread
{
	@Override
	public void run()
	{
		for(int i=1;i<=10;i++)
			System.out.println("child thread");
		System.out.println(", status = " + this.isAlive());
	}
}
public class JoinThreadDemo234 {
	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		MyJoinedThread mjt=new MyJoinedThread();
		mjt.start();
		
		mjt.join();// if t1 is execute t2.join()
			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		for(int i=1;i<=10;i++)
			System.out.println("main thread");
		   System.out.println(", status = " + mjt.isAlive());
	}
}
