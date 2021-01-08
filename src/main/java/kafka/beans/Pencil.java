package kafka.beans;

public class Pencil {
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Pencil{" +
				"color='" + color + '\'' +
				'}';
	}
}
