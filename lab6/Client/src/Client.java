import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Client {
    String vanya = "Vanya";
//    byte[] arr = {};

    InetAddress host;

    public void main() {
        try {
            byte[] arr = SerializationUtil.serialize(vanya);
            host = InetAddress.getLocalHost();
            DatagramChannel dc = DatagramChannel.open();
            int port = 1111;
            SocketAddress addr = new InetSocketAddress(host, port);
            ByteBuffer buf = ByteBuffer.wrap(arr);
            dc.send(buf, addr);
            buf.clear();
            arr = new byte[buf.limit()];
            buf.get(arr);
//            addr = dc.receive(buf);
//            vanya = (String) SerializationUtil.deserialize();
            System.out.println((String) SerializationUtil.deserialize(arr));
        } catch (UnknownHostException e ) {e.printStackTrace();} catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
