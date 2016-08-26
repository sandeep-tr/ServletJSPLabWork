package servletpro.data;

import java.util.ArrayList;
import java.util.List;

import servletpro.objects.Product;

public class ProductData {

	/**
	 * @return
	 */
	public List<Product> fetchProducts() {
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Product product = new Product();
			product.setName("Product " + i);
			product.setDate("01/01/201" + i);
			product.setDescription("Description " + i);
			product.setQuantity(i + 1);
			product.setPrice(i * 100);

			products.add(product);
		}
		return products;
	}
}
