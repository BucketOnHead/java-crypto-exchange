# java-crypto-exchange
Симулятор биржи для проведения торгов криптовалютой

[Техническое задание](./.readme/Technical%20specification.txt)

(Случился форс-мажор на 5 дней, из-за этого не смог доделать работу)

# Реализовано:
* **POST** /users - добавление пользователей

Пример запроса:
```JSON
{
    "username": "vasya_vezunchik",
    "email": "vasyu_kolbasit@mail.ru"
}
```

Пример ответа:
```JSON
{
    "secret_key": "ZmuBy1XKyz5lNYuB8XACXrFEH5eSryYWrV"
}
```
---
* **GET** /users/wallet - просмотр баланса кошелька пользователем

Пример запроса:

`Headers`: secret_key - секретный идентификатор пользователя

Пример ответа:
```JSON
{
    "RUB_wallet": 1000
}
```
---
* **POST** users/wallet/deposit - попление кошелька пользователем

Пример запроса:
```JSON
{
    "secret_key": "", // секретный ижентификатор пользователя
    "RUB_wallet": 1000
}
```

Пример ответа:
```JSON
{
    "RUB_wallet": "1000"
}
```
---
* **POST** users/wallet/withdraw - снятие средств с кошелька пользователем

Пример запроса:
```JSON
{
    "secret_key": "", // секретный ижентификатор пользователя
    "currency": "RUB",
    "count": 200,
    "credit_card": "4000 5876 3247 5964"
}
```

Пример ответа:
```JSON
{
    "RUB_wallet": "800"
}
```
# Не реализовано:
* **GET** /currencies - просмотр курса валют
* **POST** /users/wallet/exchange - конвертация валют
* **POST** /admins/currencies/rate - изменения курса валют
* **POST** /admins/currencies/wallets/sum?currency=? - подсчет суммы счетов указанной валюты
* **POST** /admins/wallets/transactions/count?from=?&to=? - статистика операций за указанный период

# В планах было:
Создать идентичный проект этому: https://github.com/BucketOnHead/java-explore-with-me, а именно:
* многомудульный проект с разделением на сервис статистики и основной сервис
* докер + postgres
