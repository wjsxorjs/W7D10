package com.sist.msg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import msg.vo.DataVO;

@RestController
public class MsgController {
    @Value("${msg}")
    String msg;


    @GetMapping("msg")
    public String getMsg() {
        DataVO dvo = new DataVO();

        dvo.setStr(msg);

        return dvo.getStr();
    }

    @GetMapping("test")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg",msg);
        mv.setViewName("test");

        return mv;
    }

}
