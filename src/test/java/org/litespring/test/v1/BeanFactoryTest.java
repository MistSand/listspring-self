package org.litespring.test.v1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.supper.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.Resource;
import org.litespring.service.v1.PetStoreService;




public class BeanFactoryTest {
	
	DefaultBeanFactory factory = null;	
	XmlBeanDefinitionReader reader = null;
	
	@Before
	public void setUp(){
		 factory = new DefaultBeanFactory();	
		 reader = new XmlBeanDefinitionReader(factory);
	}

	@Test
	public void testGetBean() {
		Resource resource = new ClassPathResource("petstore-v1.xml");
		reader.lodeBeanDefinition(resource);
		
		BeanDefinition bd = factory.getBeanDefinition("petStore");
		
		assertEquals("org.litespring.service.v1.PetStoreService", bd.getBeanClassName());
		
		PetStoreService service = (PetStoreService)factory.getBean("petStore");
		
		assertNotNull(service);
	}
	
	@Test
	public void testInvalidBean(){
		Resource resource = new ClassPathResource("petstore-v1.xml");
		reader.lodeBeanDefinition(resource);
		
		try{
			factory.getBean("invalidBean");
		}catch(BeanCreationException e){
			return;
		}
		
		Assert.fail();
		
	}
	@Test
	public void testInvalidXML(){
		
		try{
			Resource resource = new ClassPathResource("xxxx-v1.xml");
			reader.lodeBeanDefinition(resource);
		}catch(BeanDefinitionStoreException e){
			return;
		}
		
		Assert.fail();
		
	}

}
