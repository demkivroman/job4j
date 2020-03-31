package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static String getParamater(String value) {
        String rsl;
        int index = value.indexOf('=');
        rsl = value.substring(index + 1, value.length() - 9);
        return rsl;
    }
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean cycle = true;
            while (cycle) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(
                             socket.getInputStream()))) {
                    String str = in.readLine();
                    String par = getParamater(str) == null ? "" : getParamater(str);
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        str = in.readLine();
                    }
                    String outStr;
                     if (par.equals("Exit")) {
                        cycle = false;
                        outStr = "Terminate server work.";
                    } else {
                        outStr = par;
                    }
                    //out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                    out.write(outStr.getBytes());
                }
            }
        }
    }
}
