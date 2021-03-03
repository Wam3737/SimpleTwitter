package com.codepath.apps.simpleTwit.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    public String handle;
    public String name;
    public String imageUrl;
    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.handle = jsonObject.getString("screen_name");
        user.name = jsonObject.getString("name");
        user.imageUrl = jsonObject.getString("profile_image_url_https");
        return user;
    }
}
