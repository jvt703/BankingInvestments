package dev.n1t.repository;

import dev.n1t.model.Account;
import dev.n1t.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("SELECT s FROM Stock s WHERE "
            + "(:id IS NULL OR s.id = :id) "
            + "AND (:stockName IS NULL OR s.stockName LIKE %:stockName%) "
            + "AND (:stockPrice IS NULL OR s.stockPrice = :stockPrice) "
            + "AND (:stockInventory IS NULL OR s.stockInventory = :stockInventory)")
    List<Stock> findAllByQueryParams(
            @Param("id") Long id,
            @Param("stockName") String stockName,
            @Param("stockPrice") Double stockPrice,
            @Param("stockInventory") Integer stockInventory
    );


}
