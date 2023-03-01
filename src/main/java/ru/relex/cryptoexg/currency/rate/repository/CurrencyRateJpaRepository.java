package ru.relex.cryptoexg.currency.rate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.relex.cryptoexg.currency.rate.entity.CurrencyRate;

@Repository
public interface CurrencyRateJpaRepository extends JpaRepository<CurrencyRate, Long> {
}
