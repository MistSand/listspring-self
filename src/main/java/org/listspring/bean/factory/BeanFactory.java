package org.listspring.bean.factory;

import org.listspring.bean.BeanDefinition;
import org.listspring.service.v1.PetStoreService;

public interface BeanFactory {

	public BeanDefinition getBeanDefinition(String beanId);

	public Object getBean(String beanID);

}
