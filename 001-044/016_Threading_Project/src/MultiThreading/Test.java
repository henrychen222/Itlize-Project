package MultiThreading;
import java.util.Scanner;
class Customer {
	int bal = 10000;
	synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");
		if (this.bal < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch blockg
				System.out.println(" gt exceptoin");
			}
		} else {
			this.bal -= amount;
			System.out.println("withdraw completed...");
			System.out.println("The Balance in your Accoun is" + bal);
			System.exit(0);
		}
		this.bal -= amount;
		System.out.println("withdraw completed...");
		System.out.println("The Balance in your Accoun is" + bal);
	}
	synchronized void deposit(int amount) throws InterruptedException {
		// wait();
		System.out.println("going to deposit...");
		this.bal += amount;
		System.out.println("deposit completed... ");
		System.out.println("The Balance in your Accoun is" + bal);
		notifyAll();
	}
}
class Test {
	public static void main(String args[]) {
		final Customer c = new Customer();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to withdraw");
		final int a = sc.nextInt();
	
		
		new Thread() {
			@Override
			public void run() {
				c.withdraw(a);
			}
		}.start();
		
		
		
		// wait();
		new Thread() {
			@Override
			public void run() {
				try {
					c.deposit(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					e.getMessage();
				}
			}
		}.start();

	}
}