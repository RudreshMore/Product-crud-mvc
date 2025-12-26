package in.rudresh.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rudresh.entity.Product;
import in.rudresh.repository.ProductRepository;
import in.rudresh.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	// 1️⃣ Save Product
	@Override
	public Integer saveProduct(Product product) {
//        Product savedProduct = repo.save(product);
//        return savedProduct.getPId();
		return repo.save(product).getPId();
	}

	// 2️⃣ Get All Products
	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	// 3️⃣ Delete Product
	@Override
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}

	// 4️⃣ Get One Product by ID
	@Override
	public Product getOneProduct(Integer id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	}

	// 5️⃣ Update Product
	@Override
	public void updateProduct(Product product) {
		repo.save(product);
	}
}
