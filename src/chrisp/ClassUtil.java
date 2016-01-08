package chrisp;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
//任何时候要想获取类的信息，首先要获取类类型，只有获取了这个对象你才能先确定你到底要获取的是关于这个类的什么
import java.lang.reflect.Method;
/**
 * @author CP
 *成员变量也是对象。
 *Field类封装了关于成员变量的操作
 *getFields()方法获取的是所有public的成员变量的信息
 *getDelaredFields()获取的是该类自己声明的成员变量的信息。这一点对其他也适用。
 *
 */
public class ClassUtil {
	public static void getMembers(Object obj){
		Class c=obj.getClass();
		Field []fs=c.getDeclaredFields();
		for (Field field : fs) {
			//得到成员变量类型的类类型
			Class fieldType =field.getType();
			//得到成员变量类型的名字
			String typeName=fieldType.getName();
			//得到成员变量的名字
			String fieldName=field.getName();
			System.out.println(typeName+" "+fieldName);
		}
	}
	public static void getConMessage(Object obj){
		Class c=obj.getClass();
		/**
		 * 构造函数也是对象。java.lang.constructor中封装了构造函数的信息。
		 */
		//Constructor []cs =c.getConstructors();//获得所有的共有构造方法
		Constructor  [] cs=c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			System.out.print(constructor.getName()+"(");
			//获取构造函数的参数列表
			Class [] paramType=constructor.getParameterTypes();//得到的是参数列表的类类型
			for (Class class1 : paramType) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
	public static void getClassMethod(Object obj) {
		Class class1 = obj.getClass();// 传递的是哪个子类的对象。class1就是该子类的类类型
		// 得到类的名称
		System.out.println("类的名称是：" + class1.getName());
		// 得到方法的类类型数组
		Method[] ms = class1.getMethods();
		for (int i = 0; i < ms.length; i++) {
			// 得到成员方法的返回值类型
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName() + " ");
			// 得到成员方法
			System.out.print(ms[i].getName() + "(");
			// 得到参数列表
			Class[] paramType = ms[i].getParameterTypes();

			switch (paramType.length) {
			case 0:
				break;
			case 1:
				System.out.print(paramType[0].getName());
			default:
				for (int j = 0; j < paramType.length; j++) {
					if (j != paramType.length-1) {
						System.out.print(paramType[j].getName() + ",");
					} else {
						System.out.print(paramType[j].getName());
					}

				}
				break;
			}
			System.out.println(")");

		}

	}
}
