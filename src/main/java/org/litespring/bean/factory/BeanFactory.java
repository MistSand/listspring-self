package org.litespring.bean.factory;

import org.litespring.bean.BeanDefinition;
import org.litespring.service.v1.PetStoreService;

public interface BeanFactory {

	public BeanDefinition getBeanDefinition(String beanId);

	public Object getBean(String beanID);

}
