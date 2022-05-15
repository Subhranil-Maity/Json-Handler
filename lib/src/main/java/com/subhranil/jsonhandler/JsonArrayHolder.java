package com.subhranil.jsonhandler;

import com.subhranil.jsonhandler.parser.JSONParser;
import com.subhranil.jsonhandler.parser.ParseException;
import com.subhranil.jsonhandler.utils.JSONArray;
import com.subhranil.jsonhandler.utils.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("unchecked")
public class JsonArrayHolder {

    JSONArray data;

    public JsonArrayHolder(JSONArray data) {
        this.data = data;
    }

    public JsonArrayHolder() {
        this.data = new JSONArray();
    }

    public JsonArrayHolder(String data) throws ParseException {
        this.data = new JSONArray();
        this.data.add(data);
    }

    public JSONArray getData() {
        return data;
    }


    public void writeJsonToDisk(String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(data.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readJsonFromDisk(String filename) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filename)) {
            Object obj = jsonParser.parse(reader);
            this.data = (JSONArray) obj;
        } catch (FileNotFoundException f) {
            writeJsonToDisk(filename);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void add(String value) {
        this.data.add(value);
    }

    @SuppressWarnings("unchecked")
    public void add(int value) {
        this.data.add(value);
    }
    @SuppressWarnings("unchecked")
    public void add(JSONObject value) {
        this.data.add(value);
    }
    @SuppressWarnings("unchecked")
    public void add(Boolean value) {
        this.data.add(value);
    }
    @SuppressWarnings("unchecked")
    public void add(Short value) {
        this.data.add(value);
    }
    @SuppressWarnings("unchecked")
    public void add(Long value) {
        this.data.add(value);
    }
    @SuppressWarnings("unchecked")
    public void put(Double value) {
        this.data.add(value);
    }
    @SuppressWarnings("unchecked")
    public void add(float value) {
        this.data.add(value);
    }
    @SuppressWarnings("unchecked")
    public void add(JSONArray value) {
        this.data.add(value);
    }
    public String get(int index) {
        return this.data.get(index).toString();
    }
    public JSONObject getJsonObject(int index) {
        return (JSONObject) this.data.get(index);
    }
    public JSONArray getJsonArray(int index) {
        return (JSONArray) this.data.get(index);
    }

}
