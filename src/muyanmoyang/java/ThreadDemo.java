package muyanmoyang.java;

class MyThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<100; i++){
			System.out.println("mythread");	
		}
	}
}

public class ThreadDemo {
	
	public static void main(String[] args) {
		
		MyThread thread = new MyThread() ;
		MyThread2 thread2 = new MyThread2() ;
		thread.start(); 
		for(int i=0; i<100; i++){
			System.out.println("main thread"); 
		}
		
	}
	
}
