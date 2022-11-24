package it.springframework.msscjacksonexample.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    /**
     * serializing json
     */
    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    /**
     * deserializing json
    */
    @Test
    void deserializeBeerDto() throws JsonProcessingException {
        String json = "{\"beerId\":\"d1a22f1c-3b02-4dde-8ea2-daccc85675aa\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":12313213123,\"price\":12.00,\"createdDate\":\"2022-11-24T16:55:27.0365084+01:00\",\"lastUpdatedDate\":\"2022-11-24T16:55:27.0385088+01:00\"}\n";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }
}