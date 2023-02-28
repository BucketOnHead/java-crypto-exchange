CREATE TABLE IF NOT EXISTS users
(
    user_id    BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    username   VARCHAR(100) UNIQUE                             NOT NULL,
    email      VARCHAR(100) UNIQUE                             NOT NULL,
    secret_key VARCHAR(34) UNIQUE                              NOT NULL
);

CREATE TABLE IF NOT EXISTS wallets
(
    wallet_id     BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    currency_name VARCHAR(3) UNIQUE                               NOT NULL,
    mantis        BIGINT DEFAULT 0                                NOT NULL,
    exponent      INT    DEFAULT 0                                NOT NULL
);

CREATE TABLE IF NOT EXISTS user_wallets
(
    user_id   BIGINT REFERENCES users (user_id),
    wallet_id BIGINT REFERENCES wallets (wallet_id)
);
