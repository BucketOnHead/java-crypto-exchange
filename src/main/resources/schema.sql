CREATE TABLE IF NOT EXISTS users
(
    user_id    BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    username   VARCHAR(100) UNIQUE                             NOT NULL,
    email      VARCHAR(100) UNIQUE                             NOT NULL,
    secret_key VARCHAR(34) UNIQUE                              NOT NULL
);