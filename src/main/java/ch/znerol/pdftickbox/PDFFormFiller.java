package ch.znerol.pdftickbox;

import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFFormFiller implements FormFiller {

	@Override
	public String getContentType() {
		return "application/pdf";
	}

	@Override
	public void fill(InputStream template, OutputStream result, String values) throws FormFillerException {
        // step 1
        Document document = new Document();
        // step 2
        try {
			PdfWriter.getInstance(document, result);
		} catch (DocumentException e) {
			throw new FormFillerException("Failed to retrieve iText PdfWriter instance", e);
		}
        // step 3
        document.open();
        // step 4
        try {
			document.add(new Paragraph("Hello World!"));
			document.add(new Paragraph(values));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			throw new FormFillerException("Failed write paragraph into document", e);
		}
        // step 5
        document.close();
	}

}
