package ec.akira.akira_negocios.service;

import ec.akira.akira_negocios.model.dto.user.UserResponse;

public interface UserService {

    UserResponse createNewUser(UserResponse user);
}
