package com.tgorgics.instaprofilepic.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class InstaProfilePicUtils {

    private static String INSTAGRAM = "https://instagram.com/";

    public static String assembleUrl(final String userName) {
        final ObjectMapper mapper = new ObjectMapper();
        URL url;
        try {
            url = new URL(String.format("%s%s/?__a=1", INSTAGRAM, userName));
        } catch (final MalformedURLException e) {
            return "";
        }
        final Map<String, Object> jsonMap;
        try {
            jsonMap = mapper.readValue(url, Map.class);
        } catch (final IOException e) {
            return "";
        }
        return (String) jsonMap.get("profile_pic_url");
    }

}
