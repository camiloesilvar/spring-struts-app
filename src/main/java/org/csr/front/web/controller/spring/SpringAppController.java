package org.csr.front.web.controller.spring;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.csr.front.web.view.module.FormulaireBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller()
@RequestMapping("/springapp/springaction/tile/")
public class SpringAppController {

    // http://localhost:8080/spring-struts-app/app/springapp/springaction/tile/getTileAction
	@RequestMapping(value = { "/getTileAction" }, method = RequestMethod.GET)
    public String get(HttpServletRequest request) {
        return "/tiles/spring/spraction/getaction";
    }

    // http://localhost:8080/spring-struts-app/app/springapp/springaction/tile/homeformulaireAction
	@RequestMapping(value = { "/homeformulaireAction" }, method = RequestMethod.GET)
    public ModelAndView getFormulaire(HttpServletRequest request) {
        return new ModelAndView("/tiles/spring/spraction/addaction", "formulaire", new FormulaireBean());
    }

    @RequestMapping(value = { "/postformulaire" }, method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("formulaire") FormulaireBean formulaire, BindingResult result, ModelMap model) {
    	model.addAttribute("name", formulaire.getName());
        model.addAttribute("contactNumber", formulaire.getContactNumber());
        model.addAttribute("id", formulaire.getId());
        return "/tiles/spring/spraction/addaction";
    }
    
    // http://localhost:8080/spring-struts-app/app/springapp/springaction/tile/sessionInvalidate
	@RequestMapping(value = { "/sessionInvalidate" }, method = RequestMethod.GET)
    public String sessionInvalidate(HttpServletRequest request) {
    	request.getSession().invalidate();
    	return "redirect:" + request.getHeader("Referer");
    }
    
    @RequestMapping(value = { "/fragment" }, method = RequestMethod.GET)
    public String fragment() {
    	return "/fragment";
    }
}
