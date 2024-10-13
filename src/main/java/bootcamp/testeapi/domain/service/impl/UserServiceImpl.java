package bootcamp.testeapi.domain.service.impl;

import bootcamp.testeapi.domain.model.User;
import bootcamp.testeapi.domain.repository.UserRepository;
import bootcamp.testeapi.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        NoSuchElementException::new
                );
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("This User ID already exists.");
        }
        return userRepository.save(user);
    }
}
