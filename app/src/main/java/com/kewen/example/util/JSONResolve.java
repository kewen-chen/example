package com.kewen.example.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/27.
 */
public class JSONResolve {

    private static ArrayList<Stuff> list;

    public static ArrayList<Stuff> parseJSON(String jsonData) {
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");

                Stuff stuff = new Stuff();
                stuff.setId(id);
                stuff.setName(name);
                stuff.setVersion(version);

                list.add(stuff);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
