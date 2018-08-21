package org.litespring.test.v1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.supper.ClassPathXmlApplicationContext;
import org.litespring.context.supper.FileSystemXmlApplicationContext;
import org.litespring.service.v1.PetStoreService;

public class ApplicationContextTest {

	@Test
	public void testClassPathGetBean() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v1.xml");
		
		PetStoreService service = (PetStoreService)ctx.getBean("petStore");
		
		assertNotNull(service);
	}
	
	@Test
	public void testFileSystemGetBean() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("F:/LiteSpring/listspring-self/src/test/resources/petstore-v1.xml");
		
		PetStoreService service = (PetStoreService)ctx.getBean("petStore");
		
		assertNotNull(service);
	}

}
