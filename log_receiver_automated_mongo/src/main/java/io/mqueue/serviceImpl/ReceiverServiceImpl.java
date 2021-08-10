package io.mqueue.serviceImpl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.bson.Document;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.mongodb.client.MongoCollection;
import io.mqueue.service.ReceiverService;


@Service
public class ReceiverServiceImpl implements ReceiverService {
	
	@Autowired
	private RabbitTemplate rt;
	
	@Autowired
	private MongoTemplate mt;
	
	
	@Value("${properties.queue1}")
	private String queue1;
	@Value("${properties.queue2}")
	private String queue2;
	@Value("${properties.queue3}")
	private String queue3;
	@Value("${properties.queue4}")
	private String queue4;
	@Value("${properties.queue5}")
	private String queue5;
	@Value("${properties.queue6}")
	private String queue6;
	@Value("${properties.queue7}")
	private String queue7;
	@Value("${properties.queue8}")
	private String queue8;
	@Value("${properties.queue9}")
	private String queue9;
	@Value("${properties.queue10}")
	private String queue10;
	@Value("${properties.queue11}")
	private String queue11;
	@Value("${properties.queue12}")
	private String queue12;
	@Value("${properties.queue13}")
	private String queue13;
	@Value("${properties.queue14}")
	private String queue14;
	
	@Value("${properties.collection1}")
	private String collection1;
	@Value("${properties.collection2}")
	private String collection2;
	@Value("${properties.collection3}")
	private String collection3;
	@Value("${properties.collection4}")
	private String collection4;
	@Value("${properties.collection5}")
	private String collection5;
	@Value("${properties.collection6}")
	private String collection6;
	@Value("${properties.collection7}")
	private String collection7;
	@Value("${properties.collection8}")
	private String collection8;
	@Value("${properties.collection9}")
	private String collection9;
	@Value("${properties.collection10}")
	private String collection10;
	@Value("${properties.collection11}")
	private String collection11;
	@Value("${properties.collection12}")
	private String collection12;
	@Value("${properties.collection13}")
	private String collection13;
	@Value("${properties.collection14}")
	private String collection14;
	
	
	@Override
	public void startThreads() throws Exception
	{

	   //create a callable for each method
	   Callable<Void> callable1 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function1();
	         return null;
	      }
	   };

	   Callable<Void> callable2 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function2();
	         return null;
	      }
	   };

	   Callable<Void> callable3 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function3();
	         return null;
	      }
	   };
	   
	   Callable<Void> callable4 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function4();
	         return null;
	      }
	   };
	   
	   Callable<Void> callable5 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function5();
	         return null;
	      }
	   };
	   
	   Callable<Void> callable6 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function6();
	         return null;
	      }
	   };
	   
	   Callable<Void> callable7 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function7();
	         return null;
	      }
	   };
	   
	   Callable<Void> callable8 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function8();
	         return null;
	      }
	   };
	   
	   Callable<Void> callable9 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function9();
	         return null;
	      }
	   };
	   
	   Callable<Void> callable10 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function10();
	         return null;
	      }
	   };
	   
	   Callable<Void> callable11 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function11();
	         return null;
	      }
	   };
	   
	   Callable<Void> callable12 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function12();
	         return null;
	      }
	   };
	   
	   Callable<Void> callable13 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function13();
	         return null;
	      }
	   };
	   
	   Callable<Void> callable14 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  function14();
	         return null;
	      }
	   };

	   //add to a list
	   List<Callable<Void>> taskList = new ArrayList<Callable<Void>>();
	   taskList.add(callable1);
	   taskList.add(callable2);
	   taskList.add(callable3);
	   taskList.add(callable4);
	   taskList.add(callable5);
	   taskList.add(callable6);
	   taskList.add(callable7);
	   taskList.add(callable8);
	   taskList.add(callable9);
	   taskList.add(callable10);
	   taskList.add(callable11);
	   taskList.add(callable12);
	   taskList.add(callable13);
	   taskList.add(callable14);
	   

	   //create a pool executor 
	   ExecutorService executor = Executors.newFixedThreadPool(14);

	   try
	   {
	      //start the threads and wait for them to finish
	      executor.invokeAll(taskList);
	   }
	   catch (InterruptedException ie)
	   {
	      System.out.println(ie.getMessage());
	   }

	}
	
	
	

	@Override
	public void function1() throws Exception {
		
		System.out.println("Started Thread 1 with rabbitmq: "+queue1+" and mongo collection: "+collection1);
		
		while(true) {
			
		try {
			
			if(!mt.collectionExists(collection1) ) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection1);
			Message  ob1=null;
			if(mc!=null) {
				ob1= rt.receive(queue1);
			
			}
			
			if(ob1==null) {
				Thread.sleep(3000);
				continue;
			}
			
			String s1 = new String(ob1.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s1);
			mc.insertOne(bsondoc);
			
				
			
		}catch(Exception e) {
			
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function2() throws Exception {
		
		System.out.println("Started Thread 2 with rabbitmq: "+queue2+" and mongo collection: "+collection2);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection2)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection2);
			Message ob2=null;
			if(mc!=null) {
				 ob2=rt.receive(queue2);
			}
			
			if(ob2==null) {
				Thread.sleep(3000);
				continue;
			}
			String s2 = new String(ob2.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s2);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function3() throws Exception {
		
		System.out.println("Started Thread 3 with rabbitmq: "+queue3+" and mongo collection: "+collection3);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection3)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection3);
			Message ob3=null;
			if(mc!=null) {
				ob3=rt.receive(queue3);
			}
	
			if(ob3==null) {
				Thread.sleep(3000);
				continue;
			}
			String s3 = new String(ob3.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s3);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function4() throws Exception {
		
		System.out.println("Started Thread 4 with rabbitmq: "+queue4+" and mongo collection: "+collection4);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection4)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection4);
			Message ob4=null;
			if(mc!=null)  ob4=rt.receive(queue4);
			if(ob4==null) {
				Thread.sleep(3000);
				continue;
			}
			String s4 = new String(ob4.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s4);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function5() throws Exception {
		
		System.out.println("Started Thread 5 with rabbitmq: "+queue5+" and mongo collection: "+collection5);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection5)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection5);
			Message ob5=null;
			if(mc!=null) ob5=rt.receive(queue5);
			if(ob5==null) {
				Thread.sleep(3000);
				continue;
			}
			String s5 = new String(ob5.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s5);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function6() throws Exception {
		
		System.out.println("Started Thread 6 with rabbitmq: "+queue6+" and mongo collection: "+collection6);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection6)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection6);
			Message ob6=null;
			if(mc!=null) ob6=rt.receive(queue6);
			if(ob6==null) {
				Thread.sleep(3000);
				continue;
			}
			String s6 = new String(ob6.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s6);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function7() throws Exception {
		
		System.out.println("Started Thread 7 with rabbitmq: "+queue7+" and mongo collection: "+collection7);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection7)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection7);
			Message ob7=null;
			if(mc!=null) ob7=rt.receive(queue7);
			if(ob7==null) {
				Thread.sleep(3000);
				continue;
			}
			String s7 = new String(ob7.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s7);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function8() throws Exception {
		
		System.out.println("Started Thread 8 with rabbitmq: "+queue8+" and mongo collection: "+collection8);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection8)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection8);
			Message ob8=null;
			if(mc!=null) ob8=rt.receive(queue8);
			if(ob8==null) {
				Thread.sleep(3000);
				continue;
			}
			String s8 = new String(ob8.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s8);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function9() throws Exception {
		
		System.out.println("Started Thread 9 with rabbitmq: "+queue9+" and mongo collection: "+collection9);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection9)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection9);
			Message ob9=null;
			if(mc!=null) ob9=rt.receive(queue9);
			if(ob9==null) {
				Thread.sleep(3000);
				continue;
			}
			String s9 = new String(ob9.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s9);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function10() throws Exception {
		
		System.out.println("Started Thread 10 with rabbitmq: "+queue10+" and mongo collection: "+collection10);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection10)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection10);
			Message ob10=null;
			if(mc!=null) ob10=rt.receive(queue10);
			if(ob10==null) {
				Thread.sleep(3000);
				continue;
			}
			String s10 = new String(ob10.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s10);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function11() throws Exception {
		
		System.out.println("Started Thread 11 with rabbitmq: "+queue11+" and mongo collection: "+collection11);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection11)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection11);
			Message ob11=null;
			if(mc!=null) ob11=rt.receive(queue11);
			if(ob11==null) {
				Thread.sleep(3000);
				continue;
			}
			String s11 = new String(ob11.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s11);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function12() throws Exception {
		
		System.out.println("Started Thread 12 with rabbitmq: "+queue12+" and mongo collection: "+collection12);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection12)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection12);
			Message ob12=null;
			if(mc!=null) ob12=rt.receive(queue12);
			if(ob12==null) {
				Thread.sleep(3000);
				continue;
			}
			String s12 = new String(ob12.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s12);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function13() throws Exception {
		
		System.out.println("Started Thread 13 with rabbitmq: "+queue13+" and mongo collection: "+collection13);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection13)) {
				Thread.sleep(3000);
				continue;
			}
			MongoCollection<Document> mc=mt.getCollection(collection13);
			Message ob13=null;
			if(mc!=null) ob13=rt.receive(queue13);
			if(ob13==null) {
				Thread.sleep(3000);
				continue;
			}
			String s13 = new String(ob13.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s13);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}
	
	@Override
	public void function14() throws Exception {
		
		System.out.println("Started Thread 14 with rabbitmq: "+queue14+" and mongo collection: "+collection14);
		
		while(true) {
		try {
			
			if(!mt.collectionExists(collection14)) {
				Thread.sleep(3000);
				continue;
			}
			
			MongoCollection<Document> mc=mt.getCollection(collection14);
			Message ob14=null;
			if(mc!=null) ob14=rt.receive(queue14);
			if(ob14==null) {
				Thread.sleep(3000);
				continue;
			}
			String s14 = new String(ob14.getBody(), StandardCharsets.UTF_8);
			Document bsondoc=Document.parse(s14);
			mc.insertOne(bsondoc);
				
			
		}catch(Exception e) {
			Thread.sleep(3000);
		}
		}
		
	}

	

	

}
