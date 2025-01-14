package com.speedyAir.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

  public JsonNode loadJson(String fileName) {
    JsonNode rootNode = null;
    File jsonFile = new File(fileName);
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      rootNode = objectMapper.readTree(jsonFile);
      return rootNode;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return rootNode;
  }

  public List<String> getFieldNames(JsonNode rootNode) {
    Iterator<String> fieldNames = rootNode.fieldNames();
    List<String> fieldNamesList = new ArrayList<>();
    fieldNames.forEachRemaining(fieldNamesList::add);
    return fieldNamesList;
  }
}
