package org.gd.shopping.mall.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class PageController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/page")
    @ResponseBody
    public String page() {
        System.out.println("------------in page------------");
        return "bigfuckingpage";
    }

    @HystrixCommand(fallbackMethod = "toindexOffallback")
    @RequestMapping("/toindex")
    public String toindex(Model model) {
        System.out.println("进入toIndex");
        String msg = restTemplate.getForEntity("http://PROJECT-PROJECTSOLRPROVIDER/solrSeach", String.class).getBody();
        model.addAttribute("msg", msg);
        return "/index";
    }

    private String toindexOffallback(Model model) {
        System.out.println("熔断器开始起作用了!");
        String msg = "You Know,This is FallBack. Yeah,you request is die.";
        model.addAttribute("msg", msg);
        return "/index";
    }
}
