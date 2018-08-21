package org.listspring.test.v1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.listspring.bean.BeanDefinition;
import org.listspring.bean.factory.BeanFactory;
import org.listspring.bean.factory.supper.DefaultBeanFactory;
import org.listspring.service.v1.PetStoreService;


public class BeanFactoryTest {

	@Test
	public void testGetBean() {
		BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
		BeanDefinition bd = factory.getBeanDefinition("petStore");
		
		assertEquals("org.litespring.service.v1.PetStoreService", bd.getBeanClassName());
		
		PetStoreService service = (PetStoreService)factory.getBean("petStore");
		
		assertNotNull(service);
	}

}
