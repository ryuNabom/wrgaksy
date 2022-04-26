package model.product;

import java.util.ArrayList;

public class ProductCart {
	private ArrayList<ProductSingleCart> singleProducts;

	@Override
	public String toString() {
		return "ProductCart{" + "singleProducts=" + singleProducts + '}';
	}

	public void setSingleProducts(ArrayList<ProductSingleCart> singleProducts) {
		this.singleProducts = singleProducts;
	}

	public ArrayList<ProductSingleCart> getSingleProducts() {
		return singleProducts;
	}

}
