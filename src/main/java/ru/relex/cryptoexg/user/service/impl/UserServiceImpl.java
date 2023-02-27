package ru.relex.cryptoexg.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.cryptoexg.user.dto.request.AddUserRequestDto;
import ru.relex.cryptoexg.user.dto.response.UserBalanceFullResponseDto;
import ru.relex.cryptoexg.user.dto.response.UserShortResponseDto;
import ru.relex.cryptoexg.user.entity.User;
import ru.relex.cryptoexg.user.logger.UserServiceLoggerHelper;
import ru.relex.cryptoexg.user.mapper.UserMapper;
import ru.relex.cryptoexg.user.repository.UserJpaRepository;
import ru.relex.cryptoexg.user.service.UserService;
import ru.relex.cryptoexg.user.util.UserSecretKeyGenerator;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserJpaRepository userRepository;

    @Override
    @Transactional
    public UserShortResponseDto addUser(AddUserRequestDto userDto) {
        userRepository.checkUniqueEmail(userDto.getEmail());
        userRepository.checkUniqueUsername(userDto.getUsername());
        User user = UserMapper.toUser(userDto);
        user.setSecretKey(getSecretKey());
        User savedUser = userRepository.save(user);
        UserServiceLoggerHelper.userSaved(log, savedUser);
        return UserMapper.toUserShortResponseDto(savedUser);
    }

    @Override
    public UserBalanceFullResponseDto getUserBalance(String secretKey) {
        User user = userRepository.getReferenceBySecretKey(secretKey);
        var balance = UserMapper.toUserBalanceFullResponseDto(user);
        UserServiceLoggerHelper.userFullBalanceReturned(log, balance);
        return balance;
    }

    private String getSecretKey() {
        String secretKey;

        do {
            secretKey = UserSecretKeyGenerator.generateSecretKey();
        } while (userRepository.existsBySecretKey(secretKey));

        return secretKey;
    }
}
