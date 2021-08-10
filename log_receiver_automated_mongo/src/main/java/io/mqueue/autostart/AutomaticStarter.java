package io.mqueue.autostart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.mqueue.service.ReceiverService;

@Component
public class AutomaticStarter implements CommandLineRunner{

	@Autowired
	private ReceiverService rc;
	
	
	
	@Override
    public void run(String...args) throws Exception {
      try {
    	  
    	  rc.startThreads();
      }catch(Exception e){
    	  Thread.sleep(3000);
      }
		
		

    }
}
