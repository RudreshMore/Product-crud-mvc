package in.rudresh.service;

import java.util.List;

import in.rudresh.entity.Product;

public interface ProductService {
	Integer saveProduct(Product product);

	List<Product> getAllProducts();

	void deleteProduct(Integer id);

	Product getOneProduct(Integer id);

	void updateProduct(Product product);
}
