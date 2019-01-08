package com.controller.handler;

import com.sun.net.httpserver.*;
import java.io.*;

public class RootHandler implements HttpHandler {

        @Override

        public void handle(HttpExchange he) throws IOException {
                String response = "<h1>Server start success</h1>"; 
                he.sendResponseHeaders(200, response.length());
                OutputStream os = he.getResponseBody();
                os.write(response.getBytes());
                os.close();
        }

}
