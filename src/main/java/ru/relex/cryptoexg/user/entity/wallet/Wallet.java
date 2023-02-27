package ru.relex.cryptoexg.user.entity.wallet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.relex.cryptoexg.currency.CurrencyName;
import ru.relex.cryptoexg.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@NoArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private User user;

    @Column(name = "currency_name", length = 3, unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyName currencyName;

    @Column(nullable = false)
    private Long mantis = 0L;

    @Column(nullable = false)
    private Integer exponent = 0;
}

