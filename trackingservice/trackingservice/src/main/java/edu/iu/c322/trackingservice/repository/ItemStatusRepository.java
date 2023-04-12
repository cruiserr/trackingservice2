package edu.iu.c322.trackingservice.repository;

import edu.iu.c322.trackingservice.model.ItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemStatusRepository extends JpaRepository<ItemStatus, Integer> {


    @Query(value = "SELECT * FROM invoice.ItemStatus WHERE orderId = :orderId AND itemId = :itemId", nativeQuery = true)
    ItemStatus findByOrderIdandItemId(@Param("orderId") int orderId, @Param("itemId") int itemId);
}