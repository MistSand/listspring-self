package org.litespring.bean.factory.supper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.bean.BeanDefinition;
import org.litespring.bean.factory.BeanCreationException;
import org.litespring.bean.factory.BeanDefinitionStoreException;
import org.litespring.bean.factory.BeanFactory;
import org.litespring.util.ClassUtils;


public class DefaultBeanFactory implements BeanFactory {
	
	public static final String ID_ATTRIBUTE = "id";
	public static final String CLASS_ATTRIBUTE = "class";
	
	public final Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String,BeanDefinition>();

	public DefaultBeanFactory(String configFile) {
		lodeDefaultBeanFactory(configFile);
	}

	private void lodeDefaultBeanFactory(String configFile) {
		InputStream is = null;
		try{
			ClassLoader cl = ClassUtils.getDefaultClassLoader();
			is = cl.getResourceAsStream(configFile);
			SAXReader reader = new SAXReader();
			Document doc = reader.read(is);
			Element root = doc.getRootElement();
			
			Iterator<Element> iter = root.elementIterator();
			if(iter.hasNext()){
				Element ele = iter.next();
				String id = ele.attributeValue(ID_ATTRIBUTE);
				String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
				BeanDefinition bd = new GenericBeanDefinition(id,beanClassName);
				
				this.beanDefinitionMap.put(id, bd);
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

	public BeanDefinition getBeanDefinition(String beanId) {
		return this.beanDefinitionMap.get(beanId);
	}

	public Object getBean(String beanID) {
		BeanDefinition bd = this.beanDefinitionMap.get(beanID);
		if(bd == null){
			throw new BeanCreationException("Bean Definition dose not exist");
		}
		ClassLoader cl = ClassUtils.getDefaultClassLoader();
		String beanClassName = bd.getBeanClassName();
		try {
			Class<?> clazz;
			clazz = cl.loadClass(beanClassName);
			return clazz.newInstance();
		} catch (Exception e) {
			throw new BeanCreationException("create bean for "+beanClassName+" fail");
		} 
		
		
	}

}
