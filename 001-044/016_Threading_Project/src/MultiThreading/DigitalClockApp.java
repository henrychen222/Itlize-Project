package MultiThreading;
import java.util.*;
class Task implements Runnable{
Calendar c;	Date d;
public void run(){
for(;;)
{
try {
c = Calendar.getInstance();
d = c.getTime();
System.out.println(d);
Thread.sleep(5000);
}catch(Exception e){}
}}}

public class DigitalClockApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task t1=new Task();
		Thread t2=new Thread(t1);
		t2.start();
	}

}
