package org.litespring.context.supper;

import org.litespring.beans.factory.supper.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;
import org.litespring.util.ClassUtils;

public abstract class AbstractApplicationContext implements ApplicationContext{
	
	private DefaultBeanFactory factory;
	private ClassLoader beanClassLoader;

	public AbstractApplicationContext(String path) {
		factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = getResourceByPath(path);
		reader.lodeBeanDefinition(resource);
		factory.setBeanClassLoader(this.beanClassLoader);
	}

	public Object getBean(String beanID) {
		return this.factory.getBean(beanID);
	}
	
	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		this.beanClassLoader = beanClassLoader;
	}

	public ClassLoader getBeanClassLoader() {
		return (ClassLoader) (this.beanClassLoader != null?beanClassLoader:ClassUtils.getDefaultClassLoader());
	}
	
	public abstract Resource getResourceByPath(String path);

}
