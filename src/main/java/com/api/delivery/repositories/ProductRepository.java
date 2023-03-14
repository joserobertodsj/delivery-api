package com.api.delivery.repositories;

import com.api.delivery.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.id = :idProduct")
    Optional<Product>findByProductId(Long idProduct);

    @Query(value="SELECT p.* FROM tb_product p  WHERE p.id = :idProduct", nativeQuery = true)
    Optional<Product> findByProductIdNative(Long idProduct);


    @Query("SELECT p FROM Product p")
    List<Product> findAllProducts();

    @Query(value = "SELECT p.* FROM tb_product p", nativeQuery = true)
    List<Product> findAllProductsNative();
}
