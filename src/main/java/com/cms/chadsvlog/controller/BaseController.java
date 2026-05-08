package com.cms.chadsvlog.controller;

import com.cms.chadsvlog.dto.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {
    @GetMapping("/")
    @ResponseBody
    public Response<?> test(){
        return Response.success().withMessage("test").build();
    }
}
