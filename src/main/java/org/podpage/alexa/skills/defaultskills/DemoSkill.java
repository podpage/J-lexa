package org.podpage.alexa.skills.defaultskills;

import org.podpage.alexa.skills.*;
import org.podpage.alexa.skills.alexa.response.AlexaRequest;

import java.util.Random;

public class DemoSkill implements Skill {

    @Override
    public SkillResponse call(Header inheader, AlexaRequest alexaRequest) {
        ResponseContent rc = new ResponseContent();
        rc.addContent("{\"version\": \"1.0\", \"response\": { \"outputSpeech\": { \"type\": \"SSML\", \"ssml\": \"<speak>Im Moment sind " + new Random().nextInt(10) + " User auf dem Server</speak>\" }, \"reprompt\": { \"outputSpeech\": { \"type\": \"PlainText\", \"text\": \"Was willst du denn wissen?\" } }, \"shouldEndSession\": true } }");
        ResponseHeader responseHeader = new ResponseHeader(ResponseHeader.ResponseCode.CODE_200);
        responseHeader.getFields().clear();
        responseHeader.addHeaderField(Header.HeaderField.CONTENT_TYPE.setContent("application/json"));
        responseHeader.addHeaderField(Header.HeaderField.SERVER.setContent("AlexaServer by @podpage"));
        return new SkillResponse(responseHeader, rc);
    }
}
