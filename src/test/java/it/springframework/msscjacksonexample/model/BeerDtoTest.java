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
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":12313213123,\"price\":\"12.00\",\"createdDate\":\"2022-11-25T11:52:36+0100\",\"lastUpdatedDate\":\"2022-11-25T11:52:36.7198529+01:00\",\"myLocalDate\":\"20221125\",\"beerId\":\"cc23ba7e-e714-4955-88f3-6b78cbcc39c6\"}\n";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }
}