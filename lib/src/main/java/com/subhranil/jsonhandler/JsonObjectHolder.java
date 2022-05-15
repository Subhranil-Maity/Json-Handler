package com.subhranil.jsonhandler;

import com.subhranil.jsonhandler.parser.JSONParser;
import com.subhranil.jsonhandler.parser.ParseException;
import com.subhranil.jsonhandler.utils.JSONArray;
import com.subhranil.jsonhandler.utils.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Depended on {@link JSONObject}
 * <p>
 * This class {@link JsonObjectHolder} is responsible for handling json object
 */
@SuppressWarnings("unchecked")
public class JsonObjectHolder {
    JSONObject data;

    /**
     * Allows creation of JsonObject by data passed
     *
     * @param data Default Json Value
     */
    public JsonObjectHolder(JSONObject data) {
        this.data = data;
    }
    public JsonObjectHolder(){
        this.data = new JSONObject();
    }

    /**
     * Allows setting data from Json String Format while object creation
     *
     * @param data Json Data in string format
     * @throws ParseException
     */
    public JsonObjectHolder(String data) throws ParseException {
        this.data = new JSONObject((Map) new JSONParser().parse(data));
    }

    /**
     * This method let us get the stored Json data
     * @return Json Data
     */
    public JSONObject getData() {
        return data;
    }

    /**
     * This method allows writing json to disk
     *
     * @param fileName Full file path
     * <p>
     * example - writeJsonToDisk("C:\\example.json")
     */
    public void writeJsonToDisk(String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(data.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Allows reading json data from file in fisk
     *
     * @param filename Full path with file name from where Json may be read
     */
    public void readJsonFromDisk(String filename) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filename)) {
            Object obj = jsonParser.parse(reader);
            this.data = (JSONObject) obj;
        } catch (FileNotFoundException f) {
            writeJsonToDisk(filename);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Allows setting data to a specified key
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key in String Format
     */
    @SuppressWarnings("unchecked")
    public void put(String key, String value) {
        this.data.put(key, value);
    }
    /**
     * Allows setting data to a specified key
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key in Int Format
     */
    @SuppressWarnings("unchecked")
    public void put(String key, int value){
        this.data.put(key, value);
    }
    /**
     * Allows setting data to a specified key
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key in {@link JSONObject} Format
     */
    @SuppressWarnings("unchecked")
    public void put(String key, JSONObject value){
        this.data.put(key, value);
    }
    /**
     * Allows setting data to a specified key
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key in Boolean Format
     */
    @SuppressWarnings("unchecked")
    public void put(String key, Boolean value){
        this.data.put(key, value);
    }
    /**
     * Allows setting data to a specified key
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key in Short Format
     */
    @SuppressWarnings("unchecked")
    public void put(String key, Short value){
        this.data.put(key, value);
    }
    /**
     * Allows setting data to a specified key
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key in long Format
     */
    @SuppressWarnings("unchecked")
    public void put(String key, Long value){
        this.data.put(key, value);
    }
    /**
     * Allows setting data to a specified key
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key in Double Format
     */
    @SuppressWarnings("unchecked")
    public void put(String key, Double value){
        this.data.put(key, value);
    }
    /**
     * Allows setting data to a specified key
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key in float Format
     */
    @SuppressWarnings("unchecked")
    public void put(String key, float value){
        this.data.put(key, value);
    }
    /**
     * Allows setting data to a specified key
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key in {@link JSONArray} Format
     */
    @SuppressWarnings("unchecked")
    public void put(String key, JSONArray value){
        this.data.put(key, value);
    }

    /**
     * Allows getting value from Json
     * @param key key from where the value be extracted
     * @return returns the value of the {@code key} provided in String format
     */
    public String get(String key) {
        return this.data.get(key).toString();
    }
    /**
     * Allows getting value from Json
     * @param key key from where the value be extracted
     * @return returns the value of the {@code key} provided in JsonObject Format
     */
    public JSONObject getJsonObject(String key) {
        return (JSONObject) this.data.get(key);
    }
    public JSONArray getJsonArray(String key) {
        return (JSONArray) this.data.get(key);
    }
}
