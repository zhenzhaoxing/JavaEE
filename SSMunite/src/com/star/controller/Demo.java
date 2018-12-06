package com.star.controller;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
public class Demo {
	private static final String URL="http://192.168.175.3:8080/solr/";
	ApplicationContext ac = new  ClassPathXmlApplicationContext("ApplicationContext.xml");
	
	
	public static void main(String[] args) throws IOException, Exception {
		      testAdd();
	}
	@Test
      public static void testAdd() throws Exception, IOException {
    	  
    	
	SolrServer solrserver = new HttpSolrServer(URL);
		
		SolrInputDocument doc1 = new SolrInputDocument();
		doc1.setField("id", "1000");
		doc1.setField("name", "小米手机");
		doc1.setField("price", "3000");

		SolrInputDocument doc2 = new SolrInputDocument();
		doc1.setField("id", "2000");
		doc1.setField("name", "苹果手机");
		doc1.setField("price", "8000");
		solrserver.add(doc1);
		solrserver.add(doc2);
          solrserver.commit();
      }
}
