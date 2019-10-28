package com.itlize.marketplace.repositories;

import java.util.List;
import com.itlize.marketplace.entities.Item;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends BaseRepository<Item> {

  List<Item> findByCategory(String category);

  List<Item> findBySubCategory(String subCategory);

  @Query("SELECT category, subCategory FROM Item GROUP BY category, subCategory")
  List<List<String>> getGroupByCategories();

}
