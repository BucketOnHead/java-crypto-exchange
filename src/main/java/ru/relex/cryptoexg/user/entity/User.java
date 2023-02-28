package ru.relex.cryptoexg.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.relex.cryptoexg.key.entity.SecretKey;
import ru.relex.cryptoexg.user.entity.wallet.Wallet;

import javax.persistence.*;
import java.util.LinkedList;
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

    @OneToOne(optional = false)
    @JoinColumn(name = "secret_key_id")
    private SecretKey secretKey;

    @Column(length = 100, unique = true, nullable = false)
    private String username;

    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @OneToMany
    @JoinColumn(name = "wallet_id")
    private List<Wallet> wallets = new LinkedList<>();
}
