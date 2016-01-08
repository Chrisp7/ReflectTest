package chrisp;

import java.lang.reflect.Method;

public class MethodDemo1 {
	public static void main(String[] args) {
		// 要获取print（int,int）
		// 要获取一个方法就是要获取类的信息，首先要获取类的类类型
		A a1 = new A();
		Class c = a1.getClass();
		/**
		 * 获取方法，由名称和参数列表来决定 getMethod获取的是public的方法
		 */
		try {
			Method m=c.getMethod("print", new Class[]{int.class,int.class});
			//c.getMethod("print", int.class,int.class);//也可以这样
			Object o=m.invoke(a1, new Object[]{10,20});//或者也可以这样：m.invoke(a1,10,20);
			//这里就相当于a1.print(10,20);invoke()方法也是有返回值的，如果所调用的方法没有返回值，那么invoke方法返回null，如果有返回值则返回具体的返回值
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class A {
	public void print(int a, int b) {
		System.out.println(a + b);
	}

	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + "," + b.toLowerCase());
	}
}