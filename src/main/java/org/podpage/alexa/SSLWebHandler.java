package org.podpage.alexa;

import javax.net.ssl.*;
import java.security.KeyStore;
import java.security.SecureRandom;


public class SSLWebHandler extends ReceiveServer {

    public SSLWebHandler(int port) {
        super("SSLWebHander", AlexaClient.class);

        try {
            KeyStore keyStore = CertManager.getKeyStore();
            KeyManagerFactory kmf = KeyManagerFactory
                    .getInstance("SunX509");
            kmf.init(keyStore, WebManager.certkey.toCharArray());

            SSLContext sc = SSLContext.getInstance("TLS");

            TrustManagerFactory tmf = TrustManagerFactory
                    .getInstance("SunX509");
            tmf.init(keyStore);

            sc.init(kmf.getKeyManagers(), tmf.getTrustManagers(),
                    new SecureRandom());

            SSLServerSocketFactory ssf = sc.getServerSocketFactory();

            SSLServerSocket s = (SSLServerSocket) ssf
                    .createServerSocket(port);

            String[] suites = s.getSupportedCipherSuites();
            s.setEnabledCipherSuites(suites);

            setSocket(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
