package model.subscription;

public class Product_setVO {

	private int product_set_number;
	private String product_set_1st;
	private String product_set_2nd;
	private String product_set_3rd;
	private String product_set_4th;
	private String soup_check;

	public int getProduct_set_number() {
		return product_set_number;
	}

	public void setProduct_set_number(int product_set_number) {
		this.product_set_number = product_set_number;
	}

	public String getProduct_set_1st() {
		return product_set_1st;
	}

	public void setProduct_set_1st(String product_set_1st) {
		this.product_set_1st = product_set_1st;
	}

	public String getProduct_set_2nd() {
		return product_set_2nd;
	}

	public void setProduct_set_2nd(String product_set_2nd) {
		this.product_set_2nd = product_set_2nd;
	}

	public String getProduct_set_3rd() {
		return product_set_3rd;
	}

	public void setProduct_set_3rd(String product_set_3rd) {
		this.product_set_3rd = product_set_3rd;
	}

	public String getProduct_set_4th() {
		return product_set_4th;
	}

	public void setProduct_set_4th(String product_set_4th) {
		this.product_set_4th = product_set_4th;
	}

	public String getSoup_check() {
		return soup_check;
	}

	public void setSoup_check(String soup_check) {
		this.soup_check = soup_check;
	}

	@Override
	public String toString() {
		return "Product_setVO [product_set_number=" + product_set_number + ", product_set_1st=" + product_set_1st
				+ ", product_set_2nd=" + product_set_2nd + ", product_set_3rd=" + product_set_3rd + ", product_set_4th="
				+ product_set_4th + ", soup_check=" + soup_check + "]";
	}
}
