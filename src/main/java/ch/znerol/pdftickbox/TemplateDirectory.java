package ch.znerol.pdftickbox;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.lf5.util.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class TemplateDirectory implements TemplateResolver {
	private static final Logger logger = LoggerFactory.getLogger(TemplateResolver.class);

	private String directory;

	@Override
	public InputStream open(String name) throws TemplateResolverException {
		logger.info("Template directory: " + directory);

	    ClassPathResource rsrc = new ClassPathResource("test-form.pdf");
		try {
			return rsrc.getInputStream();
		} catch (IOException e) {
			throw new TemplateResolverException("Failed to load template", e);
		}
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

}
