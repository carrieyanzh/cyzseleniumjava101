package org.lambdatest.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JSONReader {
  public static Object[][] readJSON(String filePath) {
    try {
      String json = new String(Files.readAllBytes(Paths.get(filePath)));
      Gson gson = new Gson();
      Type type = new TypeToken<List<Map<String, String>>>(){}.getType();
      List<Map<String, String>> testData = gson.fromJson(json, type);

      Object[][] dataArray = new Object[testData.size()][1];
      for (int i = 0; i < testData.size(); i++) {
        dataArray[i][0] = testData.get(i);
      }
      return dataArray;
    } catch (IOException e) {
      e.printStackTrace();
      return new Object[0][0];
    }
  }
}
