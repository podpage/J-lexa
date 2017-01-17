package org.podpage.alexa;

public class WebManager {

    public static int sslport = 443;

    public static String certkey = "";

    public static AlexaServer alexaServer;

    public static void main(String... args) {
        String domain = "localhost";
        if (args.length > 0) {
            domain = args[0];
        }

        alexaServer = new AlexaServer(domain);
        alexaServer.start();
    }
}
