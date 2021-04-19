package com.personal.apisecurity.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GenericEntitySerialization {

    private GenericEntitySerialization() {
    }

    /**
     * Método para converter um objeto
     * em formato JSON para um objeto
     * JAVA
     * 
     * @param content
     * @param valueType
     * @return
     * @throws Exception 
     */
    public static <T> T convertJsonToObject(String content, Class<T> valueType) {
        try {
            return new ObjectMapper().readValue(content, valueType);
        } catch (Exception e) {
           System.out.println(e);
           return null;
        }
    }

    /**
     * Método para converter um Objeto
     * JAVA para um objeto JSON em
     * formato String
     * 
     * @param object
     * @return
     * @throws Exception 
     */
    public static String convertObjectToJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
