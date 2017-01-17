package org.podpage.alexa.skills;

import org.podpage.alexa.skills.alexa.request.AlexaRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lino on 16.01.2017.
 */
public class HttpParser {

    private Header header = null;
    private AlexaRequest alexaRequest = null;

    public HttpParser(Socket socket) {
        try {
            StringBuffer sb = new StringBuffer();

            InputStream inputStream = socket.getInputStream();
            int buffSize = socket.getReceiveBufferSize();
            if (buffSize > 0) {
                byte[] buff = new byte[buffSize];
                int ret_read = inputStream.read(buff);
                if (ret_read != -1) {
                    sb.append(new String(buff, 0, ret_read));
                }
            }
            String request = sb.toString();
            String lines[] = request.split("\\r?\\n");

            List<String> head = new ArrayList<>();
            List<String> body = new ArrayList<>();
            boolean inhead = true;
            for (String line : lines) {
                if (inhead) {
                    if (line.isEmpty()) {
                        inhead = false;
                    } else {
                        head.add(line);
                    }
                } else {
                    body.add(line);
                }
            }

            header = Header.parse(head);
            alexaRequest = AlexaRequest.parse(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Header getHeader() {
        return header;
    }

    public AlexaRequest getAlexaRequest() {
        return alexaRequest;
    }
}
