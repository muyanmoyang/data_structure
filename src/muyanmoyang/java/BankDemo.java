package muyanmoyang.java;

class Bank{
	int sum = 0 ;
	Object obj = new Object() ;
	public synchronized void add(){
//		synchronized(obj){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			sum += 100 ;
			System.out.println(Thread.currentThread().getName() + "---sum = " + sum) ;
//		}
	}
}

class Customer implements Runnable{

	Bank b = new Bank();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<3 ;i++){
			b.add();
		}
	}
	
}

public class BankDemo {
	
	public static void main(String[] args) {
		Customer c = new Customer() ;
		Thread t1 = new Thread(c) ;
		Thread t2 = new Thread(c) ;
//		Thread t3 = new Thread(c) ;
//		Thread t4 = new Thread(c) ;
		t1.start();
		t2.start();
//		t3.start();
//		t4.start();
	}
}
