package model.order;

import java.util.ArrayList;

public class OrderSet {
	// order_singleVO 1개에 order_detailVO N개가 붙어있는 형태

	private Order_singleVO single;
	private ArrayList<Order_detailVO> details = new ArrayList<Order_detailVO>();

	public Order_singleVO getSingle() {
		return single;
	}

	public void setSingle(Order_singleVO single) {
		this.single = single;
	}

	public ArrayList<Order_detailVO> getDetails() {
		return details;
	}

	public void setDetails(ArrayList<Order_detailVO> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "OrderSet [single=" + single + ", details=" + details + "]";
	}
}
