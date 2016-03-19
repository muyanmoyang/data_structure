package muyanmoyang.swadoffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  生产者消费者问题
 * @author hadoop
 *
 */
class Resource{
	private String name ;
	private int count = 1;
	private boolean flag = false ;// 表示是否有生产的物品
	private Lock lock = new ReentrantLock() ;
	private Condition condition_pro = lock.newCondition() ;
	private Condition condition_con = lock.newCondition() ;
	
	public void set(String name) throws InterruptedException{
		lock.lock();
		try{
			while(flag){
				condition_pro.await();
			}
			this.name = name + "----" + count++;
			System.out.println(Thread.currentThread().getName() + "produce ..." + this.name) ;
			flag = true ;
			condition_con.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public void out() throws InterruptedException{
		lock.lock();
		try{
			while(!flag){
				condition_con.await(); 
			}
			System.out.println(Thread.currentThread().getName() + "consumer ..." + this.name);
			System.out.println("-----------------------------");
			flag = false ;
			condition_pro.signal();
		}finally{
			lock.unlock();
		}
	}
}

class Producer implements Runnable{
	private Resource r ; 
	Producer(Resource r){
		this.r = r ;
	}
	@Override
	public void run() {
		while(true){
			try {
				r.set("慕岩");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

class Consumer implements Runnable{
	private Resource r ; 
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

public class ProducerAndConsumer {
	public static void main(String[] args) {
		Resource res = new Resource() ;
		Producer pre = new Producer(res) ;
		Consumer con = new Consumer(res) ;
		Thread t1 = new Thread(pre) ;
		Thread t2 = new Thread(pre) ;
		Thread t3 = new Thread(con) ;
		Thread t4 = new Thread(con) ;
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
