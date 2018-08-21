package org.litespring.context.supper;

import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	public ClassPathXmlApplicationContext(String path) {
		super(path);
	}

	@Override
	public Resource getResourceByPath(String path) {
		return new ClassPathResource(path,this.getBeanClassLoader());
	}
	
	

}
