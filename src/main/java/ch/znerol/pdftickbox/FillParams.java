package ch.znerol.pdftickbox;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class FillParams {
	@NotBlank
	private String values;

	@NotBlank
	@Pattern(regexp="^[^/]*$")
	private String template;

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
}
