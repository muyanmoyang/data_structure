package muyanmoyang.java;

class Ticket implements Runnable{
	public static int tick = 1000 ;
	boolean flag = true ;
	Object obj = new Object() ;
	@Override
	public void run() {
		if(flag){
				while(true){
					synchronized(obj){      // objËø
						show();    // thisËø
					}  
				}
		}
		else{
			show();
		}
	
	}
	private synchronized void show() {    // thisËø
		synchronized (obj) {   // objËø
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

public class DeadLock {
	public static void main(String[] args) throws InterruptedException {
		Ticket t = new Ticket() ;
		Thread t1 = new Thread(t) ;
		Thread t2 = new Thread(t) ;
		t1.start();
		Thread.sleep(10);
		t.flag = false ;
		t2.start();
	}
}
