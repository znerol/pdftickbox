package ch.znerol.pdftickbox;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.lf5.util.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class TemplateDirectory implements TemplateResolver {

	@Override
	public InputStream open(String name) throws TemplateResolverException {
	    ClassPathResource rsrc = new ClassPathResource("test-form.pdf");
		try {
			return rsrc.getInputStream();
		} catch (IOException e) {
			throw new TemplateResolverException("Failed to load template", e);
		}
	}

}
