0. copy kafka.zip to D:
1. Run zookeeper.(run-zookeeper.bat)
2. start kafka.(run-kafka.bat)
3. crete topic.(create-topic.bat, One time thing)
4. start producer.

5. Run CustomExecutor with - comment/uncomment line 18-22 OR 24-88 [One block at a time]
   for build : mvn clean compile assembly:single
   for running : java -jar target\kafka-test-1.0-SNAPSHOT-jar-with-dependencies.jar
6. enter below text in producer window -
  a) for book - {"name":"History"}
  b) for pencil - {"color":"Red"}

Problem - In case of Pencil, line 26-27 works perfectly even Pencil object is not KafkaRecord.
