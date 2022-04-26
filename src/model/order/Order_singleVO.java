package model.order;

public class Order_singleVO {

	private int single_number;
	private String customer_id;
	private String single_date;

	public int getSingle_number() {
		return single_number;
	}

	public void setSingle_number(int single_number) {
		this.single_number = single_number;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getSingle_date() {
		return single_date;
	}

	public void setSingle_date(String single_date) {
		this.single_date = single_date;
	}

	@Override
	public String toString() {
		return "Order_singleVO [single_number=" + single_number + ", customer_id=" + customer_id + ", single_date="
				+ single_date + "]";
	}
}
