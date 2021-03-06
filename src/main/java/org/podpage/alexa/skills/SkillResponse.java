package org.podpage.alexa.skills;

import org.podpage.alexa.skills.alexa.response.AlexaResponse;

public class SkillResponse {

    ResponseHeader responseHeader = new ResponseHeader(ResponseHeader.ResponseCode.CODE_200);
    ResponseContent responseContent = new ResponseContent();

    public SkillResponse(AlexaResponse alexaResponse) {
        this.responseHeader = responseHeader;
        this.responseContent = responseContent;
    }

    public SkillResponse(ResponseHeader responseHeader,
                         ResponseContent responseContent) {
        this.responseHeader = responseHeader;
        this.responseContent = responseContent;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public ResponseContent getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(ResponseContent responseContent) {
        this.responseContent = responseContent;
    }

}
