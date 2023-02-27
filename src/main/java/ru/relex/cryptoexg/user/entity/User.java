package ru.relex.cryptoexg.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.relex.cryptoexg.user.entity.wallet.Wallet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(length = 100, unique = true, nullable = false)
    private String username;

    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "secret_key", length = 34, unique = true, nullable = false)
    private String secretKey;

    @OneToMany
    @JoinColumn(name = "wallet_id")
    private List<Wallet> wallets = new ArrayList<>();
}
