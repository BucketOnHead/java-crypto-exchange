package ru.relex.cryptoexg.currency.rate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.relex.cryptoexg.currency.CurrencyName;

import javax.persistence.*;

@Entity
@Table(name = "currency_rates")
@Getter
@Setter
@NoArgsConstructor
public class CurrencyRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rate_id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "from_currency", length = 3, nullable = false)
    private CurrencyName from;

    @Enumerated(EnumType.STRING)
    @Column(name = "to_currency", length = 3, nullable = false)
    private CurrencyName to;

    @Column(nullable = false)
    private Integer mantis;

    @Column(nullable = false)
    private Integer exponent;
}
