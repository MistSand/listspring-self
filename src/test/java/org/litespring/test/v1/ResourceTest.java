package org.litespring.test.v1;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;

public class ResourceTest {

	@Test
	public void testClassPathResource() throws IOException {
		Resource r = new ClassPathResource("petstore-v1.xml");
		InputStream is = null;
		try{
			is = r.getInputStream();
			assertNotNull(is);
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	@Test
	public void testFileSystemResource() throws IOException {
		Resource r = new FileSystemResource("F:/LiteSpring/listspring-self/src/test/resources/petstore-v1.xml");
		InputStream is = null;
		try{
			is = r.getInputStream();
			assertNotNull(is);
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
