package org.podpage.alexa.skills;

import java.io.PrintWriter;
import java.util.ArrayList;

public class ResponseContent {

    private ArrayList<String> content = new ArrayList<>();

    public ArrayList<String> getContent() {
        return content;
    }

    public ResponseContent setContent(ArrayList<String> content) {
        this.content = content;
        return this;
    }

    public ResponseContent addContent(String line) {
        this.content.add(line);
        return this;
    }

    public void write(PrintWriter out) {
        if (getContent().size() > 0) {
            for (String line : getContent()) {
                out.println(line);
            }
        }
    }

}
