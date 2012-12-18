package ch.znerol.pdftickbox;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.FdfReader;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.XfdfReader;

@Component
public class PDFFormFiller implements FormFiller {

	@Override
	public String getContentType() {
		return "application/pdf";
	}

	@Override
	public void fill(InputStream template, OutputStream result, String values) throws FormFillerException {
		PdfReader reader;
		try {
			reader = new PdfReader(template);
		} catch (IOException e) {
			throw new FormFillerException("Failed to read PDF from template", e);
		}

		XfdfReader fdf;
		try {
			fdf = new XfdfReader(new ByteArrayInputStream(values.getBytes("UTF-8")));
		} catch (IOException e) {
			throw new FormFillerException("Failed create FDF reader", e);
		}

		PdfStamper stamper;
		try {
			stamper = new PdfStamper(reader, result);
		} catch (DocumentException e) {
			throw new FormFillerException("Failed create PDF stamper", e);
		} catch (IOException e) {
			throw new FormFillerException("Failed create PDF stamper", e);
		}

		try {
			stamper.getAcroFields().setFields(fdf);
		} catch (IOException e) {
			throw new FormFillerException("Failed fill form fields", e);
		} catch (DocumentException e) {
			throw new FormFillerException("Failed fill form fields", e);
		}

		stamper.setFormFlattening(true);

		try {
			stamper.close();
		} catch (DocumentException e) {
			throw new FormFillerException("Failed to close stamper", e);
		} catch (IOException e) {
			throw new FormFillerException("Failed to close stamper", e);
		}

        reader.close();
	}
}
