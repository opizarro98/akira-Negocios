package ec.akira.akira_negocios.service.impl;

import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.entity.Role;
import ec.akira.akira_negocios.repository.RoleRepo;
import ec.akira.akira_negocios.service.RoleService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepository;

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

}
