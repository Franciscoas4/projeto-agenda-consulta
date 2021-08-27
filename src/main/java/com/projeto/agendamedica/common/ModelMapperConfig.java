package com.projeto.agendamedica.common;

import org.modelmapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Provider<LocalDateTime> localDateProvider = new AbstractProvider<LocalDateTime>() {
            @Override
            public LocalDateTime get() {
                return LocalDateTime.now();
            }
        };

        Converter<String, LocalDateTime> toStringDate = new AbstractConverter<String, LocalDateTime>() {
            @Override
            protected LocalDateTime convert(String source) {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                return LocalDateTime.parse(source, format);
            }
        };


        modelMapper.createTypeMap(String.class, LocalDateTime.class);
        modelMapper.addConverter(toStringDate);
        modelMapper.getTypeMap(String.class, LocalDateTime.class).setProvider(localDateProvider);
        return modelMapper;
    }


}
