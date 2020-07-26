package base.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PhonebookExceptionHandler {

	@ExceptionHandler(value = PhonebookAppException.class)
	public String phonebookAppExceptionsHandler() {
		return "error";
	}
	@ExceptionHandler(value = NullPointerException.class)
	public String nullPointerExceptionsHandler() {
		return "error";
	}
}
