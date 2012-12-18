package ch.znerol.pdftickbox;

import java.io.InputStream;

public interface TemplateResolver {
	public InputStream open(String name) throws TemplateResolverException;
}
