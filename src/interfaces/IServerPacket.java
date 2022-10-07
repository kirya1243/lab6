package interfaces;

import java.net.SocketAddress;

public interface IServerPacket {
    void handleOnServer(IServer server, SocketAddress clientAddress);
}
