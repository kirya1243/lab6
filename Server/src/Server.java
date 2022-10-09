import Organization.Organization;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class Server {
//    byte arr[] = new byte[10];
    String imya = "";

    ByteBuffer buf;
    int port = 1111;

    public void main() {
        try {
            DatagramChannel dc = DatagramChannel.open();
            dc.bind(new InetSocketAddress(port));
            dc.configureBlocking(false);
            while (true) {
                byte[] arr = new byte[2048];
                ByteBuffer byteBuffer = ByteBuffer.wrap(arr);
                SocketAddress addr = dc.receive(byteBuffer);
                ByteInputStream bis = new ByteInputStream(arr, arr.length);
                String response;
                try {
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    response = (String) ois.readObject();
                    byteBuffer.clear();
                } catch (StreamCorruptedException e) {
                    continue;
                }
                System.out.println(response);
                ByteOutputStream bos = new ByteOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(response);
                oos.flush();

                byte[] arr1 = bos.getBytes();
                dc.send(ByteBuffer.wrap(arr1), addr);
            }


//            dc.bind(addr);
//            buf = ByteBuffer.wrap(arr);
//            arr = new byte[buf.limit()];
//            buf.get(arr);
//            buf.clear();
//            addr = dc.receive(buf);
//            System.out.println(addr);
//            imya = (String) SerializationUtil.deserialize(arr);
//            System.out.println(imya);



//            response = response.substring(0, response.indexOf(0));

//            dc.send(ByteBuffer.wrap(SerializationUtil.serialize(imya)), addr);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}










