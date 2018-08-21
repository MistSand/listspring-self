package org.litespring.context.supper;

import org.litespring.beans.factory.supper.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;

public class FileSystemXmlApplicationContext implements ApplicationContext {

	private DefaultBeanFactory factory;

	public FileSystemXmlApplicationContext(String configFile) {
		factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = new FileSystemResource(configFile);
		reader.lodeBeanDefinition(resource);
	}

	public Object getBean(String beanID) {
		return this.factory.getBean(beanID);
	}
}
