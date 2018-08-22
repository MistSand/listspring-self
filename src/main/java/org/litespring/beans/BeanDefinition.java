package org.litespring.beans;

public interface BeanDefinition {
	
	public static final String SCOPE_SINGLETON = "singleton";
	public static final String SCOPE_PROTOTYPE = "prototype";
	public static final String SCOPE_DEFAULT = "";
	
	public boolean isSingleton();
	public boolean isPrototype();
	
	public void setScope(String scope);
	public String getScope();
		
	public String getBeanClassName();
}
