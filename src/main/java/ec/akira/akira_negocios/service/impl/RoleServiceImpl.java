package ec.akira.akira_negocios.service.impl;

import org.springframework.stereotype.Service;

import ec.akira.akira_negocios.model.dto.role.Roledto;
import ec.akira.akira_negocios.model.entity.Role;
import ec.akira.akira_negocios.repository.RoleRepo;
import ec.akira.akira_negocios.service.RoleService;
import ec.akira.akira_negocios.service.mapper.role.RoleMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public Roledto createRole(Roledto role) {
        Role newRole = roleMapper.toEntity(role);
        return roleMapper.toDto(roleRepository.save(newRole));
    }

}
