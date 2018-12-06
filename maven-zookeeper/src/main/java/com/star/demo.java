package com.star;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

public class demo {
	private String connectString="192.168.175.3:2181,192.168.175.3:2182,192.168.175.3:2183";
	private int sessionTimeout=2000;
	private ZooKeeper zkClient;
     @Before
     public void init() throws IOException{
	 zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
		
		@Override
		public void process(WatchedEvent arg0) {
			
			
		}
	});  
   }
     
      
     @Test
      public void createNode() throws KeeperException, InterruptedException {
    	 String string = zkClient.create("/niubi","zhenzhaoxing".getBytes(),Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
    	 
    	 System.out.println(string);
     }
     
}
