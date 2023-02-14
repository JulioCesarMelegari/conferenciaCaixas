package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.entity.ReceiptCoins;

public interface ReceiptCoinsRepository extends JpaRepository<ReceiptCoins, Long> {

}
