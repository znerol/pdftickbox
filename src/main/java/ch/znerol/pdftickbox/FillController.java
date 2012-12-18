package ch.znerol.pdftickbox;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the PDF filler.
 */
@Controller
@RequestMapping(value = "/fill")
public class FillController {
	@Inject
	private TemplateResolver templateResolver;

	@Inject
	private FormFiller formFillService;

	private static final Logger logger = LoggerFactory.getLogger(FillController.class);

    /**
     * For every request for this controller, this will create a new fill
     * instance for the form.
     */
    @ModelAttribute
    public Fill newRequest() {
        return new Fill();
    }

	/**
	 * Return an HTML form where template and values can be submitted by the
	 * user.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void getForm(@ModelAttribute Fill fill, Model model) {
		model.addAttribute("fill", fill);
	}

	/**
	 * Return a PDF derived from the template by filling in the values provided.
	 * @throws FormFillerException
	 * @throws IOException
	 * @throws TemplateResolverException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void getPDF(@Validated Fill fill, HttpServletResponse response) throws FormFillerException, TemplateResolverException, IOException {
		InputStream template = templateResolver.open(fill.getTemplate());
		response.setContentType(formFillService.getContentType());
		formFillService.fill(template, response.getOutputStream(), fill.getValues());
	}
}