package com.richter.dddsample.point.presentation;

import com.richter.dddsample.point.domain.PointAddRequest;
import com.richter.dddsample.point.application.PointAddAppService;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class pointAddController {
    private final PointAddAppService service;

    @Autowired
    public pointAddController(PointAddAppService service) {
        this.service = service;
    }

    @RequestMapping(value="/point/add", method= RequestMethod.GET)
    public String add(Model model, @ModelAttribute PointAddRequest request) {
        HoldingPointEntity entity = this.service.add(request.customerId(), request.cost());
        model.addAttribute("entity", entity);
        return "point/add";
    }
}
