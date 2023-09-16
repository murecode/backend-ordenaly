package com.app.ordenaly.repositories;

import com.app.ordenaly.models.Item;
import com.app.ordenaly.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {


}
