import InputManager.InputManager;
import Organization.Organization;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import Organization.Coordinates;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Client {
    String str = "Gleb";
    Organization organization = new Organization();
    {
        organization.setCoordinates(new Coordinates());
        organization.setName(str);
    }

    public void main() {

        try {
            InetAddress host = InetAddress.getLocalHost();
            DatagramChannel dc = DatagramChannel.open();
            int port = 1111;
            SocketAddress addr = new InetSocketAddress(host, port);
            ClientInputManager cInputManager = new ClientInputManager();
            cInputManager.run();







            byte[] arr;
            ByteOutputStream bos = new ByteOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(organization);
            oos.flush();
            arr = bos.getBytes();
            ByteBuffer buf = ByteBuffer.wrap(arr);
            dc.send(buf, addr);
            buf.clear();
            arr = new byte[2048];
            buf = ByteBuffer.wrap(arr);
            dc.receive(buf);
            ByteInputStream bis = new ByteInputStream(arr, arr.length);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Organization response = (Organization) ois.readObject();
            System.out.println(response);
        } catch (ClassNotFoundException | IOException e ) {e.printStackTrace();}
    }
}
