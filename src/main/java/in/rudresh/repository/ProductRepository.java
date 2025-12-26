package in.rudresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.rudresh.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
