package ch.znerol.pdftickbox;

import java.io.InputStream;
import java.io.OutputStream;

public interface FormFiller {
	public String getContentType();

	public void fill(InputStream template, OutputStream result, String values) throws FormFillerException;
}