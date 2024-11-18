package fatecriopreto.projetotg.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.thymeleaf.exceptions.TemplateInputException;

@ControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(TemplateInputException.class)
    public String handleTemplateInputException(TemplateInputException ex, Model model)
    {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error"; // Return the name of the error template
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model)
    {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error"; // Return the name of the error template
    }
}
