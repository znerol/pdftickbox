package ch.znerol.pdftickbox;

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
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void getPDF(@Validated Fill fill, Model model) {
		logger.info("template: " + fill.getTemplate());
		logger.info("values: " + fill.getValues());
	}
}