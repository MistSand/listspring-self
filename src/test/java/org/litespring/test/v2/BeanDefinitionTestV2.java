package org.litespring.test.v2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.PropertyValue;
import org.litespring.beans.factory.config.RuntimeBeanReference;
import org.litespring.beans.factory.supper.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.supper.ClassPathXmlApplicationContext;
import org.litespring.core.io.ClassPathResource;

public class BeanDefinitionTestV2 {

	@Test
	public void testGetBeanDefinition() {
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		
		reader.lodeBeanDefinition(new ClassPathResource("petstore-v2.xml"));
		
		BeanDefinition bd = factory.getBeanDefinition("petStore");
		
		List<PropertyValue> pvs = bd.getPropertyValues();
		
		assertEquals(2,pvs.size());
		{
		PropertyValue proValue = getPropertyValue("accountDao",pvs);
		
		assertTrue(proValue.getValue() instanceof RuntimeBeanReference);
		}
		
		{
			PropertyValue proValue = getPropertyValue("itemDao",pvs);
			
			assertTrue(proValue.getValue() instanceof RuntimeBeanReference);
			}
		
		
	
	}
	
	private PropertyValue getPropertyValue(String name,List<PropertyValue> pvs){
		
		for (PropertyValue propertyValue : pvs) {
			if(name.contentEquals(propertyValue.getName())){
				return propertyValue;
			}
		}
		
		return null;
	}

}
