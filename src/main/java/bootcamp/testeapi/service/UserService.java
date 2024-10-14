package bootcamp.testeapi.service;

import bootcamp.testeapi.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);


}
