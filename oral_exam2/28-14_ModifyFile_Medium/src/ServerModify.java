import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.*;
import java.io.File;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerModify extends JFrame {
    // set up GUI and DatagramSocket
    private File textFile = new File("file.txt");
    private JTextArea displayArea; // displays packets received
    private DatagramSocket socket; // socket to connect to client

    public ServerModify() {
        super("Server");

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(400, 300); // set size of window
        setVisible(true); // show window

        try // create DatagramSocket for sending and receiving packets
        {
            socket = new DatagramSocket(6000);
        } catch (SocketException socketException) {
            socketException.printStackTrace();
            System.exit(1);
        }
    }
}
