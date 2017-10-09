package com.hdgh0g.backend.config.jackson.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.io.IOException;

@RequiredArgsConstructor
public class PageSerializer extends JsonSerializer<Page> {

    private final ObjectMapper objectMapper;

    @Override
    public void serialize(Page page, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        gen.writeObjectFieldStart("pageInfo");
            gen.writeFieldName("number");
            gen.writeNumber(page.getNumber());
            gen.writeFieldName("totalElements");
            gen.writeNumber(page.getTotalElements());
            gen.writeFieldName("last");
            gen.writeBoolean(page.isLast());
            gen.writeFieldName("totalPages");
            gen.writeNumber(page.getTotalPages());
        gen.writeEndObject();

        gen.writeFieldName("content");
        gen.writeRawValue(objectMapper.writerWithView(serializers.getActiveView()).writeValueAsString(page.getContent()));
        gen.writeEndObject();
    }
}
