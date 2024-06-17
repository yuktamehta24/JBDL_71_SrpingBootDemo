package org.gfg.JBDL_71_SrpingBootDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DemoController {

    public static Logger LOG = LoggerFactory.getLogger(DemoController.class);

    //Path variable
    @GetMapping("/test/{name}")
//    @ResponseBody
    public Student test(@PathVariable("name") String name) {
        LOG.info("I am info log");
        LOG.trace("I am trace log");
        LOG.warn("I am warn log");
        LOG.debug("I am debug log");
        LOG.error("I am error log");
        return new Student(12, "ad");
//        return "Hello, ".concat(name);
//        return "<HTML><BODY> Hello</BODY> </HTML>";
    }

    //Query parameter
    @GetMapping("/test2")
    public String test2(@RequestParam("name") String name) {
        return "Hello, ".concat(name);

    }

    @GetMapping("dynamicDemo/{name1}")
    public ModelAndView abc(@PathVariable("name1") String name1) {
        ModelAndView mv = new ModelAndView("dynamicContent.html");
        mv.addObject("name", name1);
        return mv;
    }

}
