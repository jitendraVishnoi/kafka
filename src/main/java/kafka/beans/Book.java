package kafka.beans;

public class Book implements KafkaRecord {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book{" +
				"name='" + name + '\'' +
				'}';
	}
}
