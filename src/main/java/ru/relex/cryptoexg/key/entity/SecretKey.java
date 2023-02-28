package ru.relex.cryptoexg.key.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "secret_keys")
@Getter
@Setter
@NoArgsConstructor
public class SecretKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "secret_key_id", nullable = false)
    public Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "access_type", nullable = false)
    public AccessType accessType;

    @Column(name = "key_value", length = 34, unique = true, nullable = false)
    public String value;

    public enum AccessType {USER, ADMIN}
}
