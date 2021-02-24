package native_jdbc_programming.util;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JdbcUtilTest {

	@BeforeClass // 1. 클래스 호출 전
	public static void setUpBeforeClass() throws Exception {
		System.out.printf("%s()%n", "setUpBeforeClass");
	}

	@AfterClass // 5. 클래스 수행 후
	public static void tearDownAfterClass() throws Exception {
		System.out.printf("%s()%n", "tearDownAfterClass");
	}

	@Before // 2. testGetConnection() 메서드 수행 전
	public void setUp() throws Exception {
		System.out.printf("%s()%n", "setUp");
	}

	@After // 4. testGetConnection() 메서드 수행 후
	public void tearDown() throws Exception {
		System.out.printf("%s()%n", "tearDown");
	}

	@Test // 3. 메서드 수행
	public void testGetConnection() {
		System.out.printf("%s()%n", "testGetConnection");
		Connection con = JdbcUtil.getConnection();
		System.out.println("con > " + con);
		Assert.assertNotNull(con);
		
	}

}
