package org.podpage.alexa;

import org.podpage.alexa.skills.*;
import org.podpage.alexa.skills.alexa.request.AlexaRequest;
import org.podpage.alexa.skills.defaultskills.NoAlexaSkill;
import org.podpage.alexa.skills.defaultskills.NoSkill;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AlexaClient extends ReceiveClient {

    private PrintWriter out;
    private BufferedReader in;

    public AlexaClient() {
    }

    public AlexaClient(Socket socket) {
        setSocket(socket);
    }

    @Override
    public void handle(Socket socket) {
        try {
            out = new PrintWriter(socket.getOutputStream());
            HttpParser parser = new HttpParser(socket);

            Header header = parser.getHeader();

            AlexaServer alexaServer = WebManager.alexaServer;

            if (header != null && header.hasHeaderField(Header.HeaderField.HOST) &&
                    header.getHeaderField(Header.HeaderField.HOST).getContent().split(":")[0].equals(alexaServer.getDomain())) {

                Skill skill;
                AlexaRequest alexaRequest = null;

                if (header.getRequestMethod().equals(Header.RequestMethod.POST) || header.getRequestMethod().equals(Header.RequestMethod.PUT)) {
                    skill = alexaServer.getPagebyHeader(header);
                    alexaRequest = parser.getAlexaRequest();
                } else {
                    skill = new NoAlexaSkill();
                }

                if (skill == null) {
                    skill = new NoSkill();
                }

                SkillResponse page = skill.call(header, alexaRequest);
                if (page.getResponseHeader() != null) {
                    page.getResponseHeader().write(out);
                } else {
                    new ResponseHeader().write(out);
                }
                if (page.getResponseContent() != null) {
                    page.getResponseContent().write(out);
                } else {
                    new ResponseContent().write(out);
                }
                out.flush();
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
