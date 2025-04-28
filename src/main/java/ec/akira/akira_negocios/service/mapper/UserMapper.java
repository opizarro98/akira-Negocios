package ec.akira.akira_negocios.service.mapper;

import org.mapstruct.Mapper;

import ec.akira.akira_negocios.model.entity.User;
import ec.akira.akira_negocios.service.mapper.person.PersonMapper;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface UserMapper {

    // User toEntity(UserResponse dto);

    // UserResponse toDto(User entity);
}
