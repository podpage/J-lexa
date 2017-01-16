package org.podpage.alexa.skills;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Header {

    private ArrayList<HeaderField> fields;
    private RequestMethod requestMethod;
    private String requestURL;

    public Header() {
        fields = new ArrayList<>();
    }

    public static Header parse(List<String> lines) throws IOException {
        Header header = new Header();
        lines.forEach(line -> {
            if (header.getRequestMethod() == null) {
                for (RequestMethod requestMethod : RequestMethod.values()) {
                    if (line.startsWith(requestMethod.name() + " ")) {
                        header.setRequestURL(line.split(" ")[1]);
                        header.setRequestMethod(requestMethod);
                        break;
                    }
                }
            }
            for (HeaderField headerField : HeaderField.values()) {
                if (headerField.getType() != HeaderType.RESPONSE) {
                    if (line.toLowerCase().startsWith(
                            headerField.getName().toLowerCase() + ":")) {
                        headerField.setContent(line.substring(
                                line.indexOf(":") + 1, line.length()).trim());
                        header.addHeaderField(headerField);
                    }
                }
            }
            // TODO OWN HEADER FIELDS (CUSTOM)
        });
        return header;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public ArrayList<HeaderField> getHeaderFields() {
        return fields;
    }

    public void setHeaderFields(ArrayList<HeaderField> fields) {
        this.fields = fields;
    }

    public void addHeaderField(HeaderField field) {
        this.fields.add(field);
    }

    public void removeHeaderField(HeaderField field) {
        this.fields.remove(field);
    }

    public HeaderField getHeaderField(HeaderField headerField) {
        for (HeaderField field : fields) {
            if (field.name().equals(headerField.name())) {
                return field;
            }
        }
        return null;
    }

    public boolean hasHeaderField(HeaderField headerField) {
        for (HeaderField field : fields) {
            if (field.name().equals(headerField.name())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<HeaderField> getFields() {
        return fields;
    }

    public enum RequestMethod {
        GET, POST, PUT, OPTIONS, DELETE
    }

    public enum HeaderField {
        ACCEPT("Accept", HeaderType.REQUEST), ACCEPT_CHARSET("Accept-Charset",
                HeaderType.REQUEST), ACCEPT_ENCODING("Accept-Encoding",
                HeaderType.REQUEST), ACCEPT_LANGUAGE("Accept-Language",
                HeaderType.REQUEST), AUTHORIZATION("Authorization",
                HeaderType.REQUEST), COOKIE("Cookie", HeaderType.REQUEST), EXPECT(
                "Expect", HeaderType.REQUEST), HOST("Host", HeaderType.REQUEST), REFERER(
                "Refferer", HeaderType.REQUEST), UPGRADE("Upgrade",
                HeaderType.REQUEST), USER_AGENT("User-Agent",
                HeaderType.REQUEST),

        ACCEPT_RANGES("", HeaderType.RESPONSE), AGE("Age", HeaderType.RESPONSE), ALLOW(
                "", HeaderType.RESPONSE), CONTENT_ENCODING("",
                HeaderType.RESPONSE), CONTENT_LANGUAGE("", HeaderType.RESPONSE), CONTENT_LOCATION(
                "", HeaderType.RESPONSE), CONTENT_DISPOSITION("",
                HeaderType.RESPONSE), CONTENT_RANGE("", HeaderType.RESPONSE), CONTENT_SECURITY_POLICY(
                "", HeaderType.RESPONSE), EXPIRES("", HeaderType.RESPONSE), LAST_MODIFIED(
                "", HeaderType.RESPONSE), LINK("", HeaderType.RESPONSE), LOCATION(
                "", HeaderType.RESPONSE), REFRESH("Refresh",
                HeaderType.RESPONSE), RETRY_AFTER("", HeaderType.RESPONSE), SERVER(
                "Server", HeaderType.RESPONSE), SET_COOKIE("Set-Cookie",
                HeaderType.RESPONSE), WWW_AUTHENTICATE("WWW-Authenticate",
                HeaderType.RESPONSE),

        CACHE_CONTROL("Cache-Control", HeaderType.BOTH), CONNECTION(
                "Connection", HeaderType.BOTH), CONTENT_LENGTH(
                "Content-Length", HeaderType.BOTH), CONTENT_MD5("Content-MD5",
                HeaderType.BOTH), CONTENT_TYPE("Content-Type", HeaderType.BOTH), DATE(
                "Date", HeaderType.BOTH), TRANSFER_ENCODING(
                "Transfer-Encoding", HeaderType.BOTH), CUSTOM("Custom",
                HeaderType.BOTH);

        private String name;
        private HeaderType type;
        private String content = "";

        HeaderField(String name, HeaderType type) {
            this.name = name;
            this.type = type;
        }

        public HeaderType getType() {
            return type;
        }

        public String getContent() {
            return content;
        }

        public HeaderField setContent(String content) {
            this.content = content;
            return this;
        }

        public String getName() {
            return name;
        }

        public HeaderField setName(String name) {
            if (this.equals(CUSTOM)) {
                // TODO TEST THIS!
                this.name = name;
            }
            return this;
        }

        @Override
        public String toString() {
            return name + ": " + content;
        }
    }

    public enum HeaderType {
        REQUEST, RESPONSE, BOTH
    }
}
