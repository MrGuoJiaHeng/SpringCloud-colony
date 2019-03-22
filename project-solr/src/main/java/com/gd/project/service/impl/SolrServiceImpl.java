package com.gd.project.service.impl;

import com.gd.project.service.SolrService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolrServiceImpl implements SolrService {
    @Autowired
    private SolrClient solrClient;

    public SolrDocumentList search() throws Exception {
        ModifiableSolrParams solrParams = new ModifiableSolrParams();
        solrParams.add("q", "content:草泥马");//查询条件
        solrParams.add("sort", "id asc");//排序 asc不能去掉，如果降序desc
        solrParams.add("start", "0");//分页，从第几行开始
        solrParams.add("rows", "5");//分页，一页显示多少条记录
        QueryResponse queryResponse = solrClient.query("easybuy", solrParams);
        SolrDocumentList solrDocumentsList = queryResponse.getResults();
//        List<String> countlist = new ArrayList<>();
//        for (SolrDocument solrDocument : solrDocumentsList) {
//            String title = solrDocument.get("title").toString();
//            String content = solrDocument.get("content").toString();
//            System.out.println(title + "\t" + content);
//            countlist.add(title);
//        }
        return solrDocumentsList;
    }
}
