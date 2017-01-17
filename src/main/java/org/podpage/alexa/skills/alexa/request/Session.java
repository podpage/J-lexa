package org.podpage.alexa.skills.alexa.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lino on 16.01.2017.
 */
public class Session {

    private String sessionId;
    private Application application;
    private Attributes attributes;
    private User user;
    @SerializedName("new")
    private boolean newsession;

    public String getSessionId() {
        return sessionId;
    }

    public Application getApplication() {
        return application;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public User getUser() {
        return user;
    }

    public boolean isNew() {
        return newsession;
    }
}
