package org.podpage.alexa;

import sun.security.provider.X509Factory;
import sun.security.tools.keytool.CertAndKeyGen;
import sun.security.x509.X500Name;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Scanner;

public class CertManager {

    public static KeyStore getKeyStore() {
        try {
            File certFile = new File("./key.cert");
            File storeFile = new File("./key.store");

            if (storeFile.exists()) {
                System.out.println("Loading KeyStore");
                KeyStore keyStore = KeyStore.getInstance("PKCS12");
                FileInputStream inputStream = new FileInputStream(storeFile);
                keyStore.load(inputStream, "".toCharArray());
                inputStream.close();
                return keyStore;
            }

            CertAndKeyGen certGen = new CertAndKeyGen("RSA", "SHA256WithRSA", null);
            certGen.generate(4096);

            System.out.println("Generating KeyStore");
            long validSecs = (long) 365 * 24 * 60 * 60;
            X509Certificate x509Certificate = certGen.getSelfCertificate(
                    new X500Name("CN=" + WebManager.alexaServer.getDomain() + ",O=My Organisation,L=My City,C=DE"), validSecs);

            printCertificate(certFile, x509Certificate);

            KeyStore keyStore = KeyStore.getInstance("PKCS12");

            keyStore.load(null, "".toCharArray());

            keyStore.setKeyEntry("key", certGen.getPrivateKey(), WebManager.certkey.toCharArray(),
                    new X509Certificate[]{x509Certificate});

            FileOutputStream outputStream = new FileOutputStream(storeFile);

            keyStore.store(outputStream, "".toCharArray());
            outputStream.close();

            return keyStore;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String certToString(X509Certificate cert) {

        String certificat = X509Factory.BEGIN_CERT + "\n";
        try {
            certificat += String.join("\n", DatatypeConverter.printBase64Binary(cert.getEncoded()).split("(?<=\\G.{64})"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        certificat += "\n" + X509Factory.END_CERT;

        return certificat;
    }

    public static void printCertificate(File file, X509Certificate x509Certificate) throws CertificateException {
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            pw.write(certToString(x509Certificate));
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static X509Certificate parseCertificate(File file) throws CertificateException {
        if (!file.exists()) {
            return null;
        }
        try {
            Scanner scan = new Scanner(file);
            String cert = "";
            while (scan.hasNext()) {
                cert += scan.nextLine();
            }
            scan.close();
            byte[] decoded = DatatypeConverter.parseBase64Binary(cert.replaceAll(X509Factory.BEGIN_CERT, "").replaceAll(X509Factory.END_CERT, ""));
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(decoded));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
