package ua.com.lena.homefoodstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.lena.homefoodstore.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    Page<Product> findAllByCategoryId(Long id, Pageable pageable);
}
