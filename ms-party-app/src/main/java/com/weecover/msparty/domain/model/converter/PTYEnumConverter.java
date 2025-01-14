package com.weecover.msparty.domain.model.converter;

import com.weecover.msparty.domain.model.PTY_ENUM;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class PTYEnumConverter implements AttributeConverter<PTY_ENUM, String> {
    @Override
    public String convertToDatabaseColumn(PTY_ENUM attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getId();
    }

    @Override
    public PTY_ENUM convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return PTY_ENUM.fromId(dbData);
    }

}
