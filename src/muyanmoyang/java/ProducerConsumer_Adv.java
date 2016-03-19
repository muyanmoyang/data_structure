package muyanmoyang.java;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *  生产者消费者问题  (JDK1.5版本之后的Lock)
 *  JDK1.5中提供了多线程的升级解决方案，将同步Synchronized替换成显式Lock操作
 *  将Object的wait()、notify()、notifyAll()替换成了Condition对象
 *  该对象可以通过Lock锁进行操作
 *  Synchronized同步方法中，一个锁只能对应一对wait、notify ， 若还需要wait、notify则需要
 *  建另一个锁，锁的嵌套易造成死锁；
 *  而Lock锁的方式：一个锁可以对应多个condition
 */
public class ProducerConsumer_Adv {
	public static void main(String[] args) {
		Resource2 r = new Resource2() ;
		Producer2 pred = new Producer2(r) ;
		Consumer2 cons = new Consumer2(r) ;
		Thread t1 = new Thread(pred) ;
		Thread t2 = new Thread(pred) ;
		Thread t3 = new Thread(cons) ;
		Thread t4 = new Thread(cons) ;
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
class Resource2 {
	private String name ;
	private int count = 1 ;
	private boolean flag = false ;
	private Lock lock = new ReentrantLock() ;
	private Condition condition_pro = lock.newCondition() ;
	private Condition condition_con = lock.newCondition() ;
	public void set(String name) throws InterruptedException{ 
		lock.lock();
		try{
			while(flag){
				condition_pro.await();
			}
			this.name = name + "--" + count++ ;
			System.out.println(Thread.currentThread().getName() + "   producer:"  + this.name);
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
			System.out.println(Thread.currentThread().getName() + "   consumer:"  + name) ;
			System.out.println("-----------------------------");
			flag = false ;
			condition_pro.signal();
		}finally{
			lock.unlock();
		}
	}
}

class Producer2 implements Runnable{
	private Resource2 r ;
	public Producer2(Resource2 r) {
		this.r = r ; 
	}
	@Override
	public void run() {
		while(true){
			try {
				r.set("商品");
			} catch (InterruptedException e) {
			}
		}
	}
}
class Consumer2 implements Runnable{
	private Resource2 r ; 
	public Consumer2(Resource2 r) {
		this.r = r ;
	}
	@Override
	public void run() {
		while(true){
			try {
				r.out();
			} catch (InterruptedException e) {
			} 
		}
	}
	
}


