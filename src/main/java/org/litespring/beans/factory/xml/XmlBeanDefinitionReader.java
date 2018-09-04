package org.litespring.beans.factory.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.PropertyValue;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.supper.BeanDefinitionRegistry;
import org.litespring.beans.factory.supper.DefaultBeanFactory;
import org.litespring.beans.factory.supper.GenericBeanDefinition;
import org.litespring.core.io.Resource;
import org.litespring.util.ClassUtils;
import org.litespring.util.StringUtils;

public class XmlBeanDefinitionReader {
	
	private static final String ID_ATTRIBUTE = "id";
	
	private static final String CLASS_ATTRIBUTE = "class";
	
	private static final String SCOPE_ATTRIBUTE = "scope";
	
	private static final String PROPERTY_ELEMENT = "property";
	
	private static final String NAME_ATTRIBUTE = "name";
	
	private static final String REF_ATTRIBUTE = "ref";
	
	private static final String VALUE_ATTRIBUTE = "value";
	
	private  final Log logger = LogFactory.getLog(this.getClass());
	
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
				if(ele.attribute(SCOPE_ATTRIBUTE) != null){
					bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
				}
				
				parsePropertyElement(ele,bd);
				
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

	private void parsePropertyElement(Element beanElem, BeanDefinition bd) {
			Iterator iter = beanElem.elementIterator(PROPERTY_ELEMENT);
			
			while(iter.hasNext()){
				Element ele = (Element)iter.next();
				String name = ele.attributeValue(NAME_ATTRIBUTE);
				
				if(!StringUtils.hasLength(name)){
					logger.fatal("Tag 'property' must have 'name' attribute" );
					return;
				}
				Object val = parsePropertyVlaue(ele,bd,name);
				PropertyValue pv = new PropertyValue(name,val);
				
				bd.getPropertyValues().add(pv);
							
			}
			
	}

	private Object parsePropertyVlaue(Element ele, BeanDefinition bd, String name) {
		
		Boolean 
		
		return null;
	}

}
