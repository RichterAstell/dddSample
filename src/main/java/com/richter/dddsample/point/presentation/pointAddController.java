package com.richter.dddsample.point.presentation;

import com.richter.dddsample.point.application.pointAddAppService;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class pointAddController {
    private final pointAddAppService service;

    @Autowired
    public pointAddController(pointAddAppService service) {
        this.service = service;
    }

    @RequestMapping(value="/point/add", method= RequestMethod.GET)
    public String add(Model model) {
        Integer customerId = 1; Integer cost = 1234;
        HoldingPointEntity entity = this.service.add(customerId, cost);
        model.addAttribute("entity", entity);
        return "point/add";
    }
}
