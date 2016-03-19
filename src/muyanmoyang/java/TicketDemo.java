package muyanmoyang.java;

class MyThread2 implements Runnable{
	public static int tick = 100 ;
	
	Object obj = new Object() ;
	@Override
	public void run() {
		while(true){
			synchronized(obj){
				if(tick > 0){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "  sale:" + (tick--));
				}
			}
		}
	}
}

public class TicketDemo {
	public static void main(String[] args) {
		MyThread2 t = new MyThread2() ;
		Thread t1 = new Thread(t) ;
		Thread t2 = new Thread(t) ;
		Thread t3 = new Thread(t) ;
		Thread t4 = new Thread(t) ;
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
