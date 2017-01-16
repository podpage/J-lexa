package org.podpage.alexa.skills.alexa.response;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Lino on 15.01.2017.
 */
public class AlexaRequest {

    private Session session;
    private Request request;
    private String version;

    public static AlexaRequest parse(List<String> lines) {
        AlexaRequest alexaRequest = new Gson().fromJson(String.join("", lines), AlexaRequest.class);
        return alexaRequest;
    }

    public Session getSession() {
        return session;
    }

    public Request getRequest() {
        return request;
    }

    public String getVersion() {
        return version;
    }

}
