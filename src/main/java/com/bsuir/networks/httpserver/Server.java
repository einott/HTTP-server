package com.bsuir.networks.httpserver;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private int port;

    private String directoryFrom;

    public Server(int port, String directoryFrom) {
        this.port = port;
        this.directoryFrom = directoryFrom;
    }

    void startServer() {
        try (var server = new ServerSocket(this.port)) {
            while (true) {
                //Returns the address of the endpoint this socket is bound to.
                var socket = server.accept();

                var thread = new ThreadHandler(socket, this.directoryFrom);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
