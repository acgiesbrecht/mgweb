package org.mg.mgweb.converters;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Converter(autoApply = true)
@Component(LocalDateAttributeConverter.NAME)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Timestamp> {
    public static final String NAME = "mgweb_LocalDateAttributeConverter";

    @Override
    public Timestamp convertToDatabaseColumn(LocalDate locDateTime) {
        return locDateTime == null ? null : Timestamp.valueOf(locDateTime.atStartOfDay());
    }

    @Override
    public LocalDate convertToEntityAttribute(Timestamp sqlTimestamp) {
        return sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime().toLocalDate();
    }

}
