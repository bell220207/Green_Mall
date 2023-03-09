package com.cmp.port;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class JDBCBasic {

	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void test03() {
		try {
			System.out.println("======ds======");
			System.out.println(ds);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("======test03 에러======");
		}
	}
	
	@Test
	public void test04() {
		try {
			System.out.println("sqlSessionFactory: "+sqlSessionFactory);
		}catch(Exception e) {
			
		}
	}
	
}
