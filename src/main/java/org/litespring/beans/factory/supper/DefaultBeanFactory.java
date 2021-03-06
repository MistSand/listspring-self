package org.litespring.beans.factory.supper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.config.ConfigurableBeanFactory;
import org.litespring.util.ClassUtils;


public class DefaultBeanFactory extends DefaultSingletonBeanRegistry
		implements ConfigurableBeanFactory,BeanDefinitionRegistry {
	
	public static final String ID_ATTRIBUTE = "id";
	public static final String CLASS_ATTRIBUTE = "class";
	
	public final Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();
	private Object beanClassLoader;

	public DefaultBeanFactory() {
	}

	public BeanDefinition getBeanDefinition(String beanId) {
		return this.beanDefinitionMap.get(beanId);
	}

	public Object getBean(String beanID) {
		BeanDefinition bd = getBeanDefinition(beanID);
		
		if(bd == null){
			throw new BeanCreationException("Bean Definition dose not exist");
		}
		
		if(bd.isSingleton()){
			Object bean = this.getSingleton(beanID);
			if(bean == null){
				bean = creatBean(bd);
				this.registrySingleton(beanID, bean);
			}
			return bean;
		}	
		return creatBean(bd);
	}
	
	private Object creatBean(BeanDefinition bd){
		
		ClassLoader cl = this.getBeanClassLoader();
		String beanClassName = bd.getBeanClassName();
		try {
			Class<?> clazz;
			clazz = cl.loadClass(beanClassName);
			return clazz.newInstance();
		} catch (Exception e) {
			throw new BeanCreationException("create bean for "+beanClassName+" fail");
		} 
	}

	public void registryBeanDefinition(String baenId, BeanDefinition bd) {
		this.beanDefinitionMap.put(baenId, bd);
	}

	public void setBeanClassLoader(ClassLoader beanClassLoader) {
		this.beanClassLoader = beanClassLoader;
	}

	public ClassLoader getBeanClassLoader() {
		return (ClassLoader) (this.beanClassLoader != null?beanClassLoader:ClassUtils.getDefaultClassLoader());
	}

}
