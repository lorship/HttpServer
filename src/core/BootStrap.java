package core;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 从这里开始
 */
public class BootStrap {
    public static Logger logger = Logger.getLogger(BootStrap.class);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Socket clientSocket = null;
        ServerSocket serverSocket = null;
        try {
            int port = ServerXmlParser.getPort();
            serverSocket = new ServerSocket(port);
            logger.info("server started on port - " + port);
            while (true) {
                clientSocket = serverSocket.accept();
                new Thread(new HandlerRequest(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
