package muyanmoyang.java;

public class Adapter extends adaptee implements Target{
	@Override
	public void fun2() {
		System.out.println("fun2...");
	}
}

class adaptee{
	public void fun1(){
		System.out.println("fun1...");
	}
}


