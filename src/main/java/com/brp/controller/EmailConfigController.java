package com.brp.controller;

import com.brp.entity.DepartmentEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author yuchuanshen
 * @Date Created by 2017/3/17
 * @Desc MyBase-com.brp.controller
 */
@Controller
@RequestMapping("/inner/emailConfig")
public class EmailConfigController {
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editDepartment(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/email/email_config");


        return mav;
    }
}
