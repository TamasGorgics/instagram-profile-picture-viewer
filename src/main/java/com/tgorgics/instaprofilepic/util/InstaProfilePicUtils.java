package com.tgorgics.instaprofilepic.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
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
        final JsonNode rootNode;
        try {
            rootNode = mapper.readValue(url, JsonNode.class);
        } catch (final IOException e) {
            return "";
        }
        return rootNode.path("user").path("profile_pic_url").textValue().replaceAll("/s150x150", "");
    }

}
