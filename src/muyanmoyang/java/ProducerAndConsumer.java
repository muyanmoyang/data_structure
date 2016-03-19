package muyanmoyang.java;

/**
 *    生产者消费者练习
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource3{
	private String name ;
	private int count = 1 ;
	private boolean flag = false ;
	Lock lock = new ReentrantLock() ;
	Condition condition_pro = lock.newCondition() ;
	Condition condition_con = lock.newCondition() ;
	
	public void set(String name) throws InterruptedException{
		lock.lock();
		try{
			while(flag){
				condition_pro.await();
			}
			this.name = name + "--" + (count--) ; 
			System.out.println(Thread.currentThread().getName() + "  produce..." + name) ;
			flag = true ;
			condition_con.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public void out() throws InterruptedException {
		lock.lock();
		try{
			while(!flag){
				condition_con.await();
			}
			System.out.println(Thread.currentThread().getName() + "  consumer..." + name) ;
			System.out.println("-----------------------------");
			flag = false ;
			condition_pro.signal();
		}finally{
			lock.unlock();
		}
	}
}

class Producer3 implements Runnable{
	private Resource3 r ; 
	Producer3(Resource3 r) {
		this.r = r ; 
	}
	@Override
	public void run() {
		while(true){
			try {
				r.set("慕岩") ;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer3 implements Runnable{
	private Resource3 r ;
	Consumer3(Resource3 r) {
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
public class ProducerAndConsumer {
	public static void main(String[] args) {
		Resource3 res = new Resource3() ;
		Producer3 pro = new Producer3(res) ;
		Consumer3 con = new Consumer3(res) ;
		Thread t1 = new Thread(pro) ;
		Thread t2 = new Thread(pro) ;
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
