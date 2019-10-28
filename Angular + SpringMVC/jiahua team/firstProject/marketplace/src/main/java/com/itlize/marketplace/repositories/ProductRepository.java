package com.itlize.marketplace.repositories;

import java.util.List;
import com.itlize.marketplace.entities.Product;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends BaseRepository<Product> {

  List<Product> findByCategory(String category);

  List<Product> findBySubCategory(String subCategory);

  @Query("SELECT DISTINCT category FROM Product")
  List<String> getDistinctCategories();

  @Query("SELECT category, subCategory FROM Product GROUP BY category, subCategory")
  List<?> getGroupByCategories();

}
