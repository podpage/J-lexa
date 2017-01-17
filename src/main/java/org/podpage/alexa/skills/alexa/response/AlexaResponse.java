package org.podpage.alexa.skills.alexa.response;

/**
 * Created by Lino on 16.01.2017.
 */
public class AlexaResponse {

    private String version;
    private Response response;

    public AlexaResponse(String version, Response response) {
        this.version = version;
        this.response = response;
    }

    public AlexaResponse(Response response) {
        this.version = "1.0";
        this.response = response;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
