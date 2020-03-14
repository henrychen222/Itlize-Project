package MultiThreading;
public class ProducerConsumerTest {
	public static void main(String[] args) {
		Storage c = new Storage();
		Producer p1 = new Producer(c, 1);
		Consumer c1 = new Consumer(c, 1);
		p1.start();
		c1.start();
	}
}
class Storage {
	private int contents;
	private boolean available = false;

	public synchronized int get() {
		while (available == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		available = false;
		notifyAll();
		return contents;
	}
	public synchronized void put(int value) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		contents = value;
		available = true;
		notifyAll();
	}
}
class Consumer extends Thread {
	private Storage cubbyhole;
	private int number;
	public Consumer(Storage c, int number) {
		cubbyhole = c;
		this.number = number;
	}
	public void run() {
		int value = 0;
		for (int i = 0; i < 10; i++) {
			value = cubbyhole.get();
			System.out.println("Consumer #" + this.number + " got: " + value);
		}
	}
}
class Producer extends Thread {
	private Storage cubbyhole;
	private int number;

	public Producer(Storage c, int number) {
		cubbyhole = c;
		this.number = number;
	}
	public void run() {
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		for (int i = 0; i < 3; i++) {
			cubbyhole.put(i);
			System.out.println("Producer #" + this.number + " put: " + i);
			try {
			//	sleep((int) (Math.random() * 2000));
				sleep(2000);
			//	this.interrupt();
			} catch (InterruptedException e) {
			}
		}
	}
}