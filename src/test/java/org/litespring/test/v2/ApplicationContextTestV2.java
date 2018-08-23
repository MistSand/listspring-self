package org.litespring.test.v2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.supper.ClassPathXmlApplicationContext;
import org.litespring.service.v2.PetStoreService;

public class ApplicationContextTestV2 {

	@Test
	public void testGetBeanProperty() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v1.xml");
		PetStoreService service = (PetStoreService)ctx.getBean("PetStore");
		
		assertNotNull(service.getAccount());
		assertNotNull(service.getItem());
	}

}
