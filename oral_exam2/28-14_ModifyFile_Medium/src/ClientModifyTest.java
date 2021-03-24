import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class ClientModifyTest extends JFrame{

    public static void main(String[] args) {
        ClientModify application; // declare client application

        // if no command line args
        if (args.length == 0)
            application = new ClientModify("127.0.0.1"); // connect to localhost
        else
            application = new ClientModify(args[0]); // use args to connect

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient(); // run client application
    }
}
