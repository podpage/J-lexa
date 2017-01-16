package org.podpage.alexa;

import java.lang.reflect.Constructor;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class ReceiveServer extends Thread {

    private boolean running = true;
    private ServerSocket serverSocket;
    private String name;
    private Class<? extends ReceiveClient> clienthandler;

    public ReceiveServer(String name,
                         Class<? extends ReceiveClient> clienthandler) {

        this.name = name;
        this.clienthandler = clienthandler;
    }

    @SuppressWarnings("unchecked")
    public ReceiveServer(String name, String classname) {
        this.name = name;
        try {
            this.clienthandler = (Class<? extends ReceiveClient>) Class
                    .forName(classname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        try {
            this.serverSocket.setSoTimeout(10000);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void kill() {
        this.interrupt();
        running = false;
        serverSocket = null;
    }

    public void run() {
        while (running) {
            try {
                Socket socket = serverSocket.accept();
                Constructor<? extends ReceiveClient> clientconstructor = clienthandler
                        .getConstructor(Socket.class);
                clientconstructor.newInstance(socket);
            } catch (Exception e) {
                if (!(e instanceof SocketTimeoutException)) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}