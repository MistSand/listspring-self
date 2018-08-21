package org.litespring.beans.factory.supper;

import org.litespring.beans.BeanDefinition;

public interface BeanDefinitionRegistry {
	
	BeanDefinition getBeanDefinition(String beanId);
	
	void registryBeanDefinition(String baenId,BeanDefinition bd);

}
