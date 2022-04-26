package model.order;

public class Order_detailVO {

	private int detail_number;
	private int single_number;
	private int product_number;
	private int product_count;

	public int getDetail_number() {
		return detail_number;
	}

	public void setDetail_number(int detail_number) {
		this.detail_number = detail_number;
	}

	public int getSingle_number() {
		return single_number;
	}

	public void setSingle_number(int single_number) {
		this.single_number = single_number;
	}

	public int getProduct_number() {
		return product_number;
	}

	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}

	public int getProduct_count() {
		return product_count;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}

	@Override
	public String toString() {
		return "Order_detailVO [detail_number=" + detail_number + ", single_number=" + single_number
				+ ", product_number=" + product_number + ", product_count=" + product_count + "]";
	}
}
