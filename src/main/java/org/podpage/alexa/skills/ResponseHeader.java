package org.podpage.alexa.skills;

import java.io.PrintWriter;

public class ResponseHeader extends Header {

    private ResponseCode code;

    public ResponseHeader() {
        new ResponseHeader(ResponseCode.CODE_200);
    }

    public ResponseHeader(ResponseCode code) {
        this.code = code;
        addHeaderField(Header.HeaderField.CONTENT_TYPE.setContent("application/json"));
        addHeaderField(Header.HeaderField.SERVER.setContent("AlexaServer by @podpage"));
    }

    public void write(PrintWriter out) {
        out.println("HTTP/1.0 " + code.toString());
        for (HeaderField field : getHeaderFields()) {
            if (field.getType() != HeaderType.REQUEST) {
                out.println(field.toString());
            }
        }
        out.println("");
    }

    public enum ResponseCode {
        CODE_200(200, "OK"), CODE_404(404, "Not Found"), CODE_501(501, "No Permission");

        private String message;
        private int code;

        ResponseCode(int code, String message) {
            this.message = message;
            this.code = code;
        }

        @Override
        public String toString() {
            return code + " " + message;
        }
    }
}
