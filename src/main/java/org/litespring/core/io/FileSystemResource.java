package org.litespring.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.litespring.util.Assert;

public class FileSystemResource implements Resource {
	
	private String path;
	
	private File file;

	public FileSystemResource(String path) {
		Assert.notNull(path, "path not be null");
		this.path = path;
		this.file = new File(path);
		
	}

	public InputStream getInputStream() throws IOException {
		return new FileInputStream(file);
	}

	public String getDiscription() {
		return "[ file : "+file.getAbsolutePath()+"]";
	}

}
