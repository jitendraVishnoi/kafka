import deserializer.BookDeserializer;
import deserializer.PencilDeserializer;
import java.util.Collections;
import java.util.Properties;
import java.time.Duration;
import kafka.beans.Book;
import kafka.beans.KafkaRecord;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class CustomExecutor implements Runnable {

  @Override
  public void run() {
//    Consumer<String, KafkaRecord> bookConsumer = getBookConsumer();
//    while(true) {
//      ConsumerRecords<String, KafkaRecord> bookRecords = bookConsumer.poll(Duration.ofMillis(1000));
//      bookRecords.forEach(bean -> System.out.println(bean.value()));
//    }

    Consumer<String, KafkaRecord> pencilConsumer = getPencilConsumer();
    while(true) {
      ConsumerRecords<String, KafkaRecord> pencilRecords = pencilConsumer.poll(Duration.ofMillis(1000));
      pencilRecords.forEach(bean -> System.out.println(bean.value()));
    }
  }

  public static void main(String... args) {
    new Thread(new CustomExecutor()).start();
  }

  private Consumer<String, KafkaRecord> getBookConsumer() {
    Properties props = new Properties();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, String.valueOf(true));
    props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 100);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, BookDeserializer.class.getName());
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");

    Consumer<String, KafkaRecord> consumer = new KafkaConsumer<>(props);
    consumer.subscribe(Collections.singletonList("my-topic"));

    return consumer;
  }

  private Consumer<String, KafkaRecord> getPencilConsumer() {
    Properties props = new Properties();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, String.valueOf(true));
    props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 100);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, PencilDeserializer.class.getName());
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");

    Consumer<String, KafkaRecord> consumer = new KafkaConsumer<>(props);
    consumer.subscribe(Collections.singletonList("my-topic"));

    return consumer;
  }
}
