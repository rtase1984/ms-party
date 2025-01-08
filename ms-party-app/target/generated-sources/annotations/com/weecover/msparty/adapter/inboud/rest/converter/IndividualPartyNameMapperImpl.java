package com.weecover.msparty.adapter.inboud.rest.converter;

import com.weecover.msparty.adapter.inboud.rest.dto.IndividualPartyNameDto;
import com.weecover.msparty.domain.entities.IndividualPartyName;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-08T00:45:36-0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class IndividualPartyNameMapperImpl implements IndividualPartyNameMapper {

    @Override
    public IndividualPartyName toEntity(IndividualPartyNameDto dto) {
        if ( dto == null ) {
            return null;
        }

        IndividualPartyName individualPartyName = new IndividualPartyName();

        individualPartyName.setFirstName( dto.firstName() );
        individualPartyName.setMiddleName( dto.middleName() );
        individualPartyName.setLastName( dto.lastName() );
        individualPartyName.setFirstFamilyName( dto.firstFamilyName() );
        individualPartyName.setSecondFamilyName( dto.secondFamilyName() );
        individualPartyName.setNameType( dto.nameType() );

        return individualPartyName;
    }

    @Override
    public IndividualPartyNameDto toDto(IndividualPartyName entity) {
        if ( entity == null ) {
            return null;
        }

        String firstName = null;
        String middleName = null;
        String lastName = null;
        String firstFamilyName = null;
        String secondFamilyName = null;
        String nameType = null;

        firstName = entity.getFirstName();
        middleName = entity.getMiddleName();
        lastName = entity.getLastName();
        firstFamilyName = entity.getFirstFamilyName();
        secondFamilyName = entity.getSecondFamilyName();
        nameType = entity.getNameType();

        IndividualPartyNameDto individualPartyNameDto = new IndividualPartyNameDto( nameType, firstName, middleName, firstFamilyName, secondFamilyName, lastName );

        return individualPartyNameDto;
    }
}
