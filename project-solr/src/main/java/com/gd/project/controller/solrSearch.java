package com.gd.project.controller;

import com.gd.project.service.impl.SolrServiceImpl;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class solrSearch {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    SolrServiceImpl solrService;

    public static Logger logger = LoggerFactory.getLogger(solrSearch.class);

    @RequestMapping("/solrSeach")
    @ResponseBody
    public String solrSearch() {
        logger.info("进入solr");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String str = "bigfuckingsolr";
        logger.info("返回信息");
        return str;
    }

    @RequestMapping("/solrTest")
    @ResponseBody
    public SolrDocumentList solrTest() throws Exception {
        SolrDocumentList search = solrService.search();
        return search;
    }

    @RequestMapping("/toindex2")
    public String toindex2(Model model) {
        String msg = restTemplate.getForEntity("http://shopping/index", String.class).getBody();
        model.addAttribute("msg", msg);
        return "/index";
    }
}
