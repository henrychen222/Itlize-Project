package MultiThreading;
public class ThreadDemo1 extends Thread {
	public void run(){  
		 // for(int i=1;i<=5;i++){  
		   try{  
		    Thread.sleep(3000);  
		   }catch(Exception e){System.out.println(e);}  
		  System.out.println("chaild: "+Thread.currentThread().getName());  
		  }  
		   
		public static void main(String args[]) throws InterruptedException {  
			ThreadDemo1 t1=new ThreadDemo1();  
			ThreadDemo1 t2=new ThreadDemo1();  
			ThreadDemo1 t3=new ThreadDemo1();  
		 t1.start();  
		 try{  
		 t1.join();  // it causes the currently running threads to stop executing until the thread it joins with completes its task.
		 }catch(Exception e){System.out.println(e);}  
		  //when t1 completes its task then t2 and t3 starts executing.
		 t2.start();  
		 t2.join();
		 t3.start();
		t3.join();
		 System.out.println("main thread");
		 }  
}