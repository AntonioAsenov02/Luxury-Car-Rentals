package com.example.luxurycarrentals.web;

import com.example.luxurycarrentals.model.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ObjectNotFoundAdvice {

    @ExceptionHandler({ObjectNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView onObjectNotFound(ObjectNotFoundException objectNotFoundException) {

        ModelAndView modelAndView = new ModelAndView("object-not-found");
//        modelAndView.addObject("objectId", objectNotFoundException.getObjectId());

        return modelAndView;
    }
}
