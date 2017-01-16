package org.podpage.alexa.skills.alexa.response;

/**
 * Created by Lino on 16.01.2017.
 */
public class User {
    private String userId;

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
