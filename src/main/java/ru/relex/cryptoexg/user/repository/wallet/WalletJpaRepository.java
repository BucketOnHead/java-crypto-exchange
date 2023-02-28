package ru.relex.cryptoexg.user.repository.wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.relex.cryptoexg.user.entity.wallet.Wallet;

@Repository
public interface WalletJpaRepository extends JpaRepository<Wallet, Long> {
}
