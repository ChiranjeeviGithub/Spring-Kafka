# Introduction 

This is the sample POC for Spring boot with Kafka Messaging tool.


# Pre-Request

-- Software requirements
   Java SDK1.8
   Spring boot
   Spring tool Suite or any IDE
   Kafka
   Maven
 
-- Process to run the application
   1. Start Zookeeper Server  
   2. Start Kafka Server
   3. create topic to which we are sending messages
   4. Start our application Spring-kafka 
   5. Test with Rest API

-- 
   Start Zookeeper Server: Start the zookeeper server in our local machine by following command
	D:\Development_Avecto\Kafka\kafka_2.11-0.10.2.0>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties	
	
   Start Kafka server: Start the Kafka server in our local machine by following command
    D:\Development_Avecto\Kafka\kafka_2.11-0.10.2.0>.\bin\windows\kafka-server-start.bat .\config\server.properties
    
   Create topic and we can push our messages to this topic
    D:\Development_Avecto\Kafka\kafka_2.11-0.10.2.0>.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic kafka-topic-1
    
   we can see our message in particular topic by command line consumer
    D:\Development_Avecto\Kafka\kafka_2.11-0.10.2.0>.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafka-topic-1 --from-beginning
    
   we can produce message in to queue by command line producer
    D:\Development_Avecto\Kafka\kafka_2.11-0.10.2.0>.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic kafka-topic-1
    
      
   
   
   
    
   
   
 
   
  


