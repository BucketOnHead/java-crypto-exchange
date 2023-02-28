CREATE TABLE IF NOT EXISTS secret_keys
(
    secret_key_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    access_type   VARCHAR(10)                                     NOT NULL,
    key_value     VARCHAR(34) UNIQUE                              NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    user_id       BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    username      VARCHAR(100) UNIQUE                             NOT NULL,
    email         VARCHAR(100) UNIQUE                             NOT NULL,
    secret_key_id BIGINT REFERENCES secret_keys (secret_key_id)
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
