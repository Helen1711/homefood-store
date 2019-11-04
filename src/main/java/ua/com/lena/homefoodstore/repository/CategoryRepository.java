package ua.com.lena.homefoodstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.lena.homefoodstore.entities.Category;
import ua.com.lena.homefoodstore.repository.custom.CategoryRepositoryCustom;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustom {
    Optional<Category> findByName(String name);
}
