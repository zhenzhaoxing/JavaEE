package cn.starsw.pojo;

public class Log {
	private int id;
	
	private String accOut;
	private double money;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAccOut() {
		return accOut;
	}
	public void setAccOut(String accOut) {
		this.accOut = accOut;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", accIn=" +   ", accOut=" + accOut + ", money=" + money + "]";
	}


}
