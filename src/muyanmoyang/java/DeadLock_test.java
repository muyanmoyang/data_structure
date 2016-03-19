package muyanmoyang.java;

class Dead implements Runnable{
	boolean flag = true ;
	Dead(boolean flag){
		this.flag = flag ;
	}
	@Override
	public synchronized void run() {
		
		if(flag){
//			while(true){
				synchronized (MyObject.obj1) {
					System.out.println(Thread.currentThread().getName()+" if obj1...");
					synchronized (MyObject.obj2) {
						System.out.println(Thread.currentThread().getName() + " if obj2..");
					}
				}
				
//			}
		}
		else{
//			while(true){
				synchronized (MyObject.obj2) {
					System.out.println(Thread.currentThread().getName() + "   else obj2...") ;
					synchronized (MyObject.obj1) {
						System.out.println(Thread.currentThread().getName() + "  else obj1...");
					}
				}
					
//			}
		}

	}
	
}

class MyObject{
	static Object obj1 = new Object() ;
	static Object obj2 = new Object() ;
}

public class DeadLock_test{
	public static void main(String[] args) {
		Dead d1 = new Dead(true) ;
		Dead d2 = new Dead(false) ;
		Thread t1 = new Thread(d1) ;
		Thread t2 = new Thread(d2) ;
		t1.start();
		t2.start();
	}
}
