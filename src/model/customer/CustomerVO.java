package model.customer;

public class CustomerVO {
	private String customer_id;
	private String customer_password;
	private String customer_name;
	private String phone_number;
	private String ZIP_code;
	private String detailed_address;

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getZIP_code() {
		return ZIP_code;
	}

	public void setZIP_code(String zIP_code) {
		ZIP_code = zIP_code;
	}

	public String getDetailed_address() {
		return detailed_address;
	}

	public void setDetailed_address(String detailed_address) {
		this.detailed_address = detailed_address;
	}

	@Override
	public String toString() {
		return "CustomerVO [customer_number=" + ", customer_id=" + customer_id + ", customer_password="
				+ customer_password + ", customer_name=" + customer_name + ", phone_number=" + phone_number
				+ ", ZIP_code=" + ZIP_code + ", detailed_address=" + detailed_address + "]";
	}
}
