package basic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LambdaTest {
	List<String> names;
	String[] orderNames = {"xenia", "peter", "mike", "anna"};
	
	@Before
	public void setUp() throws Exception {
		names = Arrays.asList("peter", "anna", "mike", "xenia");
	}

	@After
	public void tearDown() throws Exception {
		assertArrayEquals(names.toArray(), orderNames);
	}
	

	/**
	 * 在 java8 之前对 List 排序一般是创建一个匿名的比较器对象然后将其传递给 sort 方法
	 */
	@Test
	public void test() {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		
	}

	/**
	 * 在 java8 中可使用 Lambda 表达式来实现
	 */
	@Test
	public void testLambda() {
		Collections.sort(names, (String a, String b) -> {
			return b.compareTo(a);
		});
	}

	/**
	 * 对于函数体只有一行代码的，你可以去掉大括号以及 return 关键字
	 */
	@Test
	public void testLambdaNoReturn() {
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
	}

	/**
	 * 由于 java 编译器可以自动推导出参数类型，所以类型也可以省略
	 */
	@Test
	public void testLambdaNoType() {
		Collections.sort(names, (a, b) -> b.compareTo(a));
	}
}
