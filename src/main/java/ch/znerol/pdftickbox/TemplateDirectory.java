package ch.znerol.pdftickbox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

@Component
public class TemplateDirectory implements TemplateResolver {
	private String directory;

	@Override
	public InputStream open(String name) throws TemplateResolverException {
		try {
			return new FileInputStream(directory + "/" + name + ".pdf");
		} catch (FileNotFoundException e) {
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