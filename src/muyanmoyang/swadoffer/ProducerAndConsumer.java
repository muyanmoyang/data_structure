package muyanmoyang.swadoffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  生产者消费者问题
 * @author hadoop
 *
 */
public class ProducerAndConsumer {
	public static void main(String[] args) {
		Resource res = new Resource() ;
		Producer pro = new Producer(res) ;
		Consumer con = new Consumer(res) ;
		Thread t1 = new Thread(pro) ;
		Thread t2 = new Thread(pro) ;
		Thread t3 = new Thread(con) ;
		Thread t4 = new Thread(con) ;
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class Resource{
	String name ;
	int count = 1 ; 
	boolean flag = false ;
	Lock lock = new ReentrantLock() ;
	Condition con_pro = lock.newCondition() ;
	Condition con_con = lock.newCondition() ;
	
	public void set(String name) throws InterruptedException{
		lock.lock(); 
		try{
			while(flag){       
				con_pro.await();  // 
			}
			this.name = name + "--" + count++ ;
			System.out.println(Thread.currentThread().getName() + "produce..." + this.name);
			flag = true ;
			con_con.signal();
		}finally{
			lock.unlock();
		}
	}
	public void out() throws InterruptedException{
		lock.lock(); 
		try{
			while(!flag){
				con_con.await();  // 
			}
			System.out.println(Thread.currentThread().getName() + "consumer..." + this.name);
			System.out.println("---------------------------------------");
			flag = false ;
			con_pro.signal();
		}finally{
			lock.unlock();
		}
	}		
}
class Producer implements Runnable {
	Resource r ; 
	Producer(Resource r) {
		this.r = r ;
	}
	@Override
	public void run() {
		while(true){
			try {
				r.set("莫阳");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{
	Resource r ;
	Consumer(Resource r){
		this.r = r ;
	}
	@Override
	public void run() {
		while(true){
			try {
				r.out();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

