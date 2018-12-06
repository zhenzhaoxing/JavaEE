package cn.starsw.pojo;

public class Computer {
private int id;
	@Override
public String toString() {
	return "Computer [id=" + id + ", price=" + price + "]";
}
	public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
	private int price;

}
