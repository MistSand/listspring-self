package org.litespring.context.supper;

import org.litespring.beans.factory.supper.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;

public abstract class AbstractApplicationContext implements ApplicationContext{
	
	private DefaultBeanFactory factory;

	public AbstractApplicationContext(String path) {
		factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = getResourceByPath(path);
		reader.lodeBeanDefinition(resource);
	}

	public Object getBean(String beanID) {
		return this.factory.getBean(beanID);
	}
	
	public abstract Resource getResourceByPath(String path);

}
