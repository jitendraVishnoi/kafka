package deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import kafka.beans.Book;
import org.apache.kafka.common.serialization.Deserializer;

public class BookDeserializer implements Deserializer<Book> {
	
	@Override
	public Book deserialize(String topic, byte[] data) {
			ObjectMapper OBJECT_MAPPER = new ObjectMapper();
		try {
			return OBJECT_MAPPER.readValue(new String(data, StandardCharsets.UTF_8), Book.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
