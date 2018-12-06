package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class demo {
	       private static final String URL="http://192.168.175.3:8080/solr/";
	    
         public void add() throws SolrServerException, IOException {
        	 SolrClient client=new HttpSolrClient(URL);
        	 SolrInputDocument doc = new SolrInputDocument();
        	 doc.addField("id", "3");
        	 doc.addField("title", "标物");
        	 doc.addField("t_book", "这是java从入门到精通");
        	 doc.addField("author", "90.0");
        	 
       	 SolrInputDocument doc2 = new SolrInputDocument();
        	 doc2.addField("id", "4");
        	 doc2.addField("title", "标题废");
        	 doc2.addField("t_book", "c语言编程");
        	 doc2.addField("author", "300");
        	 
        	 SolrInputDocument doc3 = new SolrInputDocument();
        	 doc3.addField("id", "2000");
        	 doc3.addField("title", "无量天尊");
        	 doc3.addField("t_book", "python编程");
        	 doc3.addField("author", "50");
        	 client.add(doc3);
        	/* client.add(doc2);
        	 client.add(doc3);*/
        	 client.commit();
         }
         @Test
         public void del() throws SolrServerException, IOException {
        	 SolrClient client=new HttpSolrClient(URL);
        	 List<String> ids=new ArrayList<String>();
        	 ids.add("8888");
        	 client.deleteById(ids);
        	 client.commit();
         }
         
         
         @Test
     	public void testQuery() throws SolrServerException, IOException{
        	
        	 SolrClient client=new HttpSolrClient(URL);
            SolrQuery params = new SolrQuery();
            params.setQuery("*:*");
          //  params.setQuery("t_book:编程");
          //设置分页
    		//从第几条开始查询,从0开始
    		params.setStart(0);
    		//查询几个
    		params.setRows(10);
    		
    		//启动高亮
    		params.setHighlight(true);
    		//设置高亮列
    		params.addHighlightField("bjsxt");
    		//设置前缀
    		params.setHighlightSimplePre("<span style='color:red;'>");
    		//设置后缀
    		params.setHighlightSimplePost("</span>");
    		
        	  QueryResponse queryResponse = client.query(params);
        	  Map<String, Map<String, List<String>>> hh = queryResponse.getHighlighting();
        	  
        	  
        	  
        	  
        	 SolrDocumentList list = queryResponse.getResults();
        	 for (SolrDocument doc : list) {
        		 System.out.println(doc.getFieldValue("id"));
     			System.out.println("未高亮:"+doc.getFieldValue("author"));
     			Map<String, List<String>> map = hh.get(doc.getFieldValue("id"));
     			System.out.println(map);
     			//list可能为null
     			List<String> list1 = map.get("t_book");
     			System.out.println(list1);
     			if(list1!=null&&list1.size()>0){
     				System.out.println("高亮:"+list1.get(0));
     			}else{
     				System.out.println("没有高亮内容");
     			}
     			System.out.println(doc.getFieldValue("bjsxt1"));
			}
         }
         
         
         
}
