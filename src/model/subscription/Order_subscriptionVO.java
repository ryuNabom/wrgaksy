package model.subscription;

public class Order_subscriptionVO {

	private int subscription_number;
	private int product_set_number;
	private String customer_id;
	private String subscription_date;
	private int subscription_price;
	private String starting_date;
	private String expiration_date;
	private String soup_check;

	public int getSubscription_number() {
		return subscription_number;
	}

	public void setSubscription_number(int subscription_number) {
		this.subscription_number = subscription_number;
	}

	public int getProduct_set_number() {
		return product_set_number;
	}

	public void setProduct_set_number(int product_set_number) {
		this.product_set_number = product_set_number;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getSubscription_date() {
		return subscription_date;
	}

	public void setSubscription_date(String subscription_date) {
		this.subscription_date = subscription_date;
	}

	public int getSubscription_price() {
		return subscription_price;
	}

	public void setSubscription_price(int subscription_price) {
		this.subscription_price = subscription_price;
	}

	public String getStarting_date() {
		return starting_date;
	}

	public void setStarting_date(String starting_date) {
		this.starting_date = starting_date;
	}

	public String getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getSoup_check() {
		return soup_check;
	}

	public void setSoup_check(String soup_check) {
		this.soup_check = soup_check;
	}

	@Override
	public String toString() {
		return "Order_subscriptionVO [subscription_number=" + subscription_number + ", product_set_number="
				+ product_set_number + ", customer_id=" + customer_id + ", subscription_date=" + subscription_date
				+ ", subscription_price=" + subscription_price + ", starting_date=" + starting_date
				+ ", expiration_date=" + expiration_date + ", soup_check=" + soup_check + "]";
	}

}
