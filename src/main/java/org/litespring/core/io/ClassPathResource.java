package org.litespring.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.litespring.util.ClassUtils;

public class ClassPathResource implements Resource {
	
	private String path;
	
	private ClassLoader loader; 
	
	public ClassPathResource(String path) {
		this(path,(ClassLoader)null);
	}
	
	public ClassPathResource(String path ,ClassLoader loader) {
		this.path = path;
		this.loader = loader != null?loader:ClassUtils.getDefaultClassLoader();
	}

	public InputStream getInputStream() throws IOException {
		InputStream is = this.loader.getResourceAsStream(this.path);
		if(is == null){
			throw new FileNotFoundException(path + "cannot be opend");
		}
		return is;
	}

	public String getDiscription() {
		return this.path;
	}
	
	

}
