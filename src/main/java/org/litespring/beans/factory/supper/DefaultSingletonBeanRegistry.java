package org.litespring.beans.factory.supper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.litespring.beans.factory.config.SingletonBeanRegistry;
import org.litespring.util.Assert;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	
	private final Map<String,Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);
	

	public void registrySingleton(String beanName, Object singletonObject) {
		Assert.notNull(beanName, "beanName be not null");
		
		Object oldObject = singletonObjects.get(beanName);
		
		if(oldObject != null){
			throw new IllegalStateException("Could not register object [" + singletonObject +
					"] under bean name '" + beanName + "': there is already object [" + oldObject + "] bound");
		}
		
		singletonObjects.put(beanName, singletonObject);
	}

	public Object getSingleton(String beanName) {
		return singletonObjects.get(beanName);
	}

}
