package com.geekbrains.book.store.repositories;

import com.geekbrains.book.store.entities.Order;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>, JpaSpecificationExecutor<Order> {
}
