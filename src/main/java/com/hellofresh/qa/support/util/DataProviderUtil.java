package com.hellofresh.qa.support.util;

import com.hellofresh.qa.support.exceptions.FrameworkException;
import com.hellofresh.qa.support.exceptions.ScriptException;
import com.hellofresh.qa.support.exceptions.UnknownException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.yaml.snakeyaml.Yaml;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class DataProviderUtil {

    public static JSONObject readTestData(String fileName) throws FrameworkException {
        JSONParser parser = new JSONParser();
        URL testdataURL = DataProviderUtil.class.getClassLoader().getResource("testdata/" + fileName);
        JSONObject obj;
        try {
            obj = (JSONObject) parser.parse(new FileReader(testdataURL.getPath()));
            return obj;
        } catch (IOException e) {
            throw new ScriptException(e.getMessage());
        } catch (ParseException e) {
            throw new ScriptException(e.getMessage());
        } catch (Exception e) {
            throw new UnknownException(e.getMessage());
        }
    }


}
