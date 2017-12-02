package com.hdgh0g.backend.config.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.hdgh0g.backend.config.jackson.serializers.InstantSerializer;
import com.hdgh0g.backend.config.jackson.serializers.PageSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Configuration
@RequiredArgsConstructor
public class JacksonConfig {

    private final ObjectMapper objectMapper;

    @PostConstruct
    public void setup() {
        Module pageSerializerModule = new SimpleModule("PageSerializerModule", getVersion())
                .addSerializer(Page.class, new PageSerializer(objectMapper));
        Module instantTimeSerializerModule = new SimpleModule("InstantTimeSerializerModule", getVersion())
                .addSerializer(Instant.class, new InstantSerializer());
        objectMapper
                .registerModule(pageSerializerModule)
                .registerModule(instantTimeSerializerModule);
    }

    private Version getVersion() {
        return new Version(1, 0, 0, null, null, null);
    }
}