package model.product;

public class ProductSingleCart {
	private ProductVO productVO;
	private int product_count;

	public int getProduct_price() {
		return this.productVO.getProduct_price() * this.product_count;
	}

	@Override
	public String toString() {
		return "ProductSingleCart{" + "productVO=" + productVO + ", product_count=" + product_count + '}';
	}

	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}

	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}

	public ProductVO getProductVO() {
		return productVO;
	}

	public int getProduct_count() {
		return product_count;
	}
}
