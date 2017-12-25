package com.tinker.factory.findme.util.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Created by hans_h'bravo on 24/12/2017
 */
public class JsonDateSimpleSerializer extends JsonSerializer<Date> {
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            //new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void serialize (Date value, JsonGenerator gen, SerializerProvider arg2)
            throws IOException, JsonProcessingException {
        gen.writeString(formatter.format(value));
    }
}