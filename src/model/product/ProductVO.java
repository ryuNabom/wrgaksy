package model.product;

public class ProductVO {
	private int product_number;
	private String product_name;
	private int product_price;
	private String product_type;
	private String details;

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

	private String product_image;

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getProduct_image() {
		return product_image;
	}

	@Override
	public String toString() {
		return "ProductVO{" + "product_number=" + product_number + ", product_name='" + product_name + '\''
				+ ", product_price=" + product_price + ", product_type='" + product_type + '\'' + ", product_image='"
				+ product_image + '\'' + '}';
	}

	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public int getProduct_number() {
		return product_number;
	}

	public String getProduct_name() {
		return product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public String getProduct_type() {
		return product_type;
	}

}
