package org.listspring.bean.factory.supper;

import org.listspring.bean.BeanDefinition;
import org.listspring.bean.factory.BeanFactory;


public class DefaultBeanFactory implements BeanFactory {

	public DefaultBeanFactory(String configFile) {
		lodeDefaultBeanFactory(configFile);
	}

	private void lodeDefaultBeanFactory(String configFile) {
		
	}

	public BeanDefinition getBeanDefinition(String beanId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getBean(String beanID) {
		// TODO Auto-generated method stub
		return null;
	}

}
