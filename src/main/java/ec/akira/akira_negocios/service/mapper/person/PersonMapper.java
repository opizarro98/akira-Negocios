package ec.akira.akira_negocios.service.mapper.person;

import org.mapstruct.Mapper;

import ec.akira.akira_negocios.model.dto.person.PersonResponse;
import ec.akira.akira_negocios.model.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toEntity(PersonResponse personResponse);

    PersonResponse toDto(Person person);
}
