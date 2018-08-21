package org.litespring.context.supper;

import org.litespring.core.io.FileSystemResource;
import org.litespring.core.io.Resource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

	public FileSystemXmlApplicationContext(String path) {
		super(path);
	}

	@Override
	public Resource getResourceByPath(String path) {
		return new FileSystemResource(path);
	}
}
