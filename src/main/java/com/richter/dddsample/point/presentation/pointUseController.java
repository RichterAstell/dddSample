package com.richter.dddsample.point.presentation;

import com.richter.dddsample.point.domain.PointUseRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class pointUseController {
//    private final PointUseAppService service;
//
//    @Autowired
//    public pointUseController(PointUseAppService service) {
//        this.service = service;
//    }
//
    @RequestMapping(value="/point/use", method= RequestMethod.GET)
    public String use(Model model, @ModelAttribute PointUseRequest request) {
        return "point/use";
    }
}
