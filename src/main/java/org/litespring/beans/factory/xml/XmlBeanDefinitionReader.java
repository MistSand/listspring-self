package org.litespring.beans.factory.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.supper.BeanDefinitionRegistry;
import org.litespring.beans.factory.supper.DefaultBeanFactory;
import org.litespring.beans.factory.supper.GenericBeanDefinition;
import org.litespring.core.io.Resource;
import org.litespring.util.ClassUtils;

public class XmlBeanDefinitionReader {
	
	private static final String ID_ATTRIBUTE = "id";
	
	private static final String CLASS_ATTRIBUTE = "class";
	
	BeanDefinitionRegistry registry;

	public XmlBeanDefinitionReader(DefaultBeanFactory registry) {
		this.registry = registry;
	}
	
	public void lodeBeanDefinition(Resource resource) {
		InputStream is = null;
		try{
			
			is = resource.getInputStream();
			SAXReader reader = new SAXReader();
			Document doc = reader.read(is);
			Element root = doc.getRootElement();
			
			Iterator<Element> iter = root.elementIterator();
			if(iter.hasNext()){
				Element ele = iter.next();
				String id = ele.attributeValue(ID_ATTRIBUTE);
				String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
				BeanDefinition bd = new GenericBeanDefinition(id,beanClassName);
				
				this.registry.registryBeanDefinition(id, bd);
			}
		}catch(Exception e){
			throw new BeanDefinitionStoreException(" Create Definition from xml filed", e);
		}finally {
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					throw new BeanDefinitionStoreException("IO Exception for XML", e);
				}
			}
		}
	}

}
