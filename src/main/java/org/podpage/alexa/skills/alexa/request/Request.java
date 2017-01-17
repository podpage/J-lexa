package org.podpage.alexa.skills.alexa.request;

/**
 * Created by Lino on 16.01.2017.
 */
public class Request {

    private RequestType type;
    private String requestId;
    private String locale;
    private String timestamp;
    private Intent intent;

    public RequestType getType() {
        return type;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getLocale() {
        return locale;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Intent getIntent() {
        return intent;
    }

    private enum RequestType {
        IntentRequest
    }
}
