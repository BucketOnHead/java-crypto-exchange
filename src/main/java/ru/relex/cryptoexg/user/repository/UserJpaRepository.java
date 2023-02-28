package ru.relex.cryptoexg.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.relex.cryptoexg.user.entity.User;
import ru.relex.cryptoexg.user.exception.NotUniqueUserEmailException;
import ru.relex.cryptoexg.user.exception.NotUniqueUserUsernameException;
import ru.relex.cryptoexg.user.exception.UserNotFoundException;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsBySecretKey(String secretKey);

    Optional<User> findBySecretKey(String secretKey);

    default User getReferenceBySecretKey(String secretKey) {
        Optional<User> user = findBySecretKey(secretKey);

        if (user.isEmpty()) {
            throw UserNotFoundException.fromSecretKey(secretKey);
        }

        return user.get();
    }

    /**
     * Метод проверяет, содержится ли в хранилище
     * пользователь с указанной почтой.
     *
     * @param email почта пользователя.
     * @throws NotUniqueUserEmailException в случае, если пользователь
     *                                     с такой почтой уже существует.
     */
    default void checkUniqueEmail(String email) {
        if (existsByEmail(email)) {
            throw NotUniqueUserEmailException.fromUserEmail(email);
        }
    }

    /**
     * Метод проверяет, содержится ли в хранилище
     * пользователь с указанным псевдонимом.
     *
     * @param username псевдоним пользователя.
     * @throws NotUniqueUserUsernameException в случае, если пользователь
     *                                        с таким псевдонимом уже существует.
     */
    default void checkUniqueUsername(String username) {
        if (existsByUsername(username)) {
            throw NotUniqueUserUsernameException.fromUserName(username);
        }
    }
}
