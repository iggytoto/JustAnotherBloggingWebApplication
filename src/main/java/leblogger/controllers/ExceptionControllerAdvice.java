package leblogger.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler({SQLException.class})
    public ModelAndView databaseError() {
        ModelAndView mav = new ModelAndView("error.jsp");
        mav.addObject("errorName", "Database error");
        mav.addObject("errorMessage", "Sorry, we are have a problem with database.\n" +
                "But we'll fix it in a few minutes.");
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e) {
        ModelAndView mav = new ModelAndView("error.jsp");
        mav.addObject("errorName", e.getClass().getSimpleName());
        mav.addObject("errorMessage", e.getMessage());
        return mav;
    }
}