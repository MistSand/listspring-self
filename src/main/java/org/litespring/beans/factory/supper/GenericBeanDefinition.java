package org.litespring.beans.factory.supper;

import java.util.List;

import org.litespring.beans.BeanDefinition;
import org.litespring.beans.PropertyValue;

public class GenericBeanDefinition implements BeanDefinition{

	private String id;
	private String beanClassName;
	
	private Boolean singleton = true;
	private Boolean prototype = false;
	
	private String scope = SCOPE_DEFAULT;
	
	
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

	public boolean isSingleton() {
		return this.singleton;
	}

	public boolean isPrototype() {
		return this.prototype;
	}

	public void setScope(String scope) {
		this.scope = scope;	
		this.singleton = SCOPE_DEFAULT.equals(scope) || SCOPE_SINGLETON.equals(scope);
		this.prototype = SCOPE_PROTOTYPE.equals(scope);
	}

	public String getScope() {
		return this.scope;
	}

	public List<PropertyValue> getPropertyValues() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
