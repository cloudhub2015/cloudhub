package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slim3.repackaged.org.json.JSONArray;
import org.slim3.repackaged.org.json.JSONException;
import org.slim3.repackaged.org.json.JSONObject;

/**
 * Library used to perform certain functions that are not supplied by the framework. 
 * @author Nelson Ruiz Jr.
 * @version 0.01 
 * Version History
 * [09/06/2015] 0.01 - Nelson Ruiz Jr. - Initial codes
 */

public class Util {
    
    /**
     * Method used to convert a JSONObject into a Map.
     * @param JSONObject json - JSON to be converted.
     * @return Map<String, Object> - the result Map.
     */
    public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
        Map<String, Object> retMap = new HashMap<String, Object>();

        if (json != JSONObject.NULL) {
            retMap = toMap(json);
        }
        
        return retMap;
    }
    
    /**
     * Parse the JSONObject to its equivalent Map
     * @param JSONObject json - JSON object.
     * @return Map<String, Object> - Mapped from JSON.
     */
    @SuppressWarnings("unchecked")
    protected static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            
            map.put(key, value);
        }
       
        return map;
    }

    /**
     * Method used to return the list of Objects, if the object is a JSONArray.
     * @param JSONArray array - JSONArray object.
     * @return List<Object> - the result List.
     */
    protected static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }
}
