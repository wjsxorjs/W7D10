package com.sist.demo;


import org.springframework.web.bind.annotation.RestController;

import test.vo.DataVO;
import test.vo.TestVO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestController {
    // @RestController = @Controller + @ResponseBody

    private String msg;

    @Value("${global.guestId}")
    private String guestId;
    @Value("${global.siteName}")
    private String siteName;

    @GetMapping("test")
    public String test() {
        return "Hello, World!";
    }
    
    @GetMapping("test1")
    public String test1() {
        return guestId+"/"+siteName;
    }
    
    
    @GetMapping("test2/{var}")
    // public String varTest(@PathVariable("var") String var ) {
    public String varTest(@PathVariable String var ) {

        return var;
    }
    

    @GetMapping("req1")
    public String getReq(String name, String email ) {
        return name+"/"+email;
    }
    

    @GetMapping("req2")
    public String getReq2(@RequestParam String name,@RequestParam String email ) {
        return name+"/"+email;
    }
    
    @GetMapping("req3/{a}")
    public String getReq3( @PathVariable String a , @RequestParam String b, @RequestParam String c ) {
        return a + "/" + b + "/" + c;
    }

    @GetMapping("req4")
    public String getReq4() {
        TestVO tvo = new TestVO();
        tvo.setId(guestId);
        tvo.setName(siteName);

        return "TVO: "+tvo.getId() + "/" + tvo.getName();
    }

    @GetMapping("req5")
    public String getReq5() {
        // DataVO dvo = new DataVO("message");
        DataVO dvo = new DataVO();
        dvo.setMsg("message");
        return "MSG: "+dvo.getMsg();
    }
    

}
