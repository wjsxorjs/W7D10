package com.sist.msg;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("test2")
    public ModelAndView test2(@RequestParam int v1,@RequestParam int v2) {
        ModelAndView mv = new ModelAndView();

        mv.addObject("res",v1+v2);
        mv.setViewName("res");

        return mv;
    }

    @GetMapping("today")
    public ModelAndView today() {
        ModelAndView mv = new ModelAndView();

        Date date = new Date();
        SimpleDateFormat todayFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

        String today = todayFormat.format(date);

        mv.addObject("today", today);
        mv.setViewName("today");

        return mv;
    }
}
