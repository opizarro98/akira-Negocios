package ec.akira.akira_negocios.service.mapper.role;

import org.mapstruct.Mapper;

import ec.akira.akira_negocios.model.dto.role.Roledto;
import ec.akira.akira_negocios.model.entity.Role;

@Mapper(componentModel = "spring")
public abstract class RoleMapper {

    public Role toEntity(Roledto roleDto) {
        if (roleDto == null) {
            return null;
        }

        Role role = Role.builder()
                .roleId(roleDto.getRoleId())
                .name(roleDto.getName())
                .description(roleDto.getDescription())
                .build();

        return role;
    }

    public Roledto toDto(Role role) {
        if (role == null) {
            return null;
        }

        Roledto roleDto = new Roledto();
        roleDto.setRoleId(role.getRoleId());
        roleDto.setName(role.getName());
        roleDto.setDescription(role.getDescription());

        return roleDto;
    }
}
