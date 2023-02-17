package com.softuni.mobilele.web;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {
    public ModelAndView view(String viewName, ModelAndView modelAndView) {
        modelAndView.setViewName(viewName);

        return modelAndView;
    }

    public ModelAndView view(String viewName) {
        return this.view(viewName, new ModelAndView());
    }

    public ModelAndView redirect(String url) {
        return this.view("redirect:" + url); // redirect:redirect:/url
    }
}
