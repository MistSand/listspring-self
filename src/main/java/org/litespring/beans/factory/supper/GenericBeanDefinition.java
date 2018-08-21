package org.litespring.beans.factory.supper;

import org.litespring.beans.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition{

	private String id;
	private String beanClassName;
	
	public GenericBeanDefinition(String id, String beanClassName) {
		super();
		this.id = id;
		this.beanClassName = beanClassName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
	}
	
	

}
