package ru.relex.cryptoexg.key.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.relex.cryptoexg.key.entity.SecretKey;

@Repository
public interface SecretKeyJpaRepository extends JpaRepository<SecretKey, Long> {

    boolean existsByValue(String value);
}
