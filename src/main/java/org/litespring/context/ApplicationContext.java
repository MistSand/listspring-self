package org.litespring.context;

import org.litespring.beans.factory.config.ConfigurableBeanFactory;

public interface ApplicationContext extends ConfigurableBeanFactory{

	Object getBean(String beanID);
	
	

}
