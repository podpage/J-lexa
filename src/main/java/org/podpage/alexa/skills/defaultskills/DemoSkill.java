package org.podpage.alexa.skills.defaultskills;

import com.google.gson.Gson;
import org.podpage.alexa.skills.*;
import org.podpage.alexa.skills.alexa.request.AlexaRequest;
import org.podpage.alexa.skills.alexa.response.*;
import org.podpage.alexa.skills.alexa.response.ssml.Speak;

public class DemoSkill implements Skill {

    @Override
    public SkillResponse call(Header inheader, AlexaRequest alexaRequest) {

        ResponseContent rc = new ResponseContent();

        Reprompt reprompt = new Reprompt(new PlainText("TEST"));

        Response response = new Response(new SSMLText(new Speak("Hello I'm a test")), reprompt);
        AlexaResponse alexaResponse = new AlexaResponse(response);

        rc.addContent(new Gson().toJson(alexaResponse));

        //rc.addContent("{\"version\": \"1.0\", \"response\": { \"outputSpeech\": { \"type\": \"SSML\", \"ssml\": \"<speak>Im Moment sind " + new Random().nextInt(10) + " User auf dem Server</speak>\" }, \"reprompt\": { \"outputSpeech\": { \"type\": \"Text\", \"text\": \"Was willst du denn wissen?\" } }, \"shouldEndSession\": true } }");
        ResponseHeader responseHeader = new ResponseHeader(ResponseHeader.ResponseCode.CODE_200);
        return new SkillResponse(responseHeader, rc);
    }
}
