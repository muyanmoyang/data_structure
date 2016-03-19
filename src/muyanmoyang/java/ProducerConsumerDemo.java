package muyanmoyang.java;

/*
 *  生产者消费者问题
 */
public class ProducerConsumerDemo {
	public static void main(String[] args) {
		Resource r = new Resource() ;
		Producer pred = new Producer(r) ;
		Consumer cons = new Consumer(r) ;
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
class Resource {
	private String name ;
	private int count = 1 ;
	private boolean flag = false ;
	public synchronized void set(String name){
		while(flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name + "--" + count++ ;
		System.out.println(Thread.currentThread().getName() + "   producer:"  + this.name);
		flag = true ;
		this.notifyAll();
 	}
	public synchronized void out(){
		while(!flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "   consumer:"  + name) ;
		System.out.println("-----------------------------");
		flag = false ;
		this.notifyAll();
	}
}

class Producer implements Runnable{
	private Resource r ;
	public Producer(Resource r) {
		this.r = r ; 
	}
	@Override
	public void run() {
		while(true){
			r.set("商品");
		}
	}
}
class Consumer implements Runnable{
	private Resource r ; 
	public Consumer(Resource r) {
		this.r = r ;
	}
	@Override
	public void run() {
		while(true){
			r.out(); 
		}
	}
	
}


