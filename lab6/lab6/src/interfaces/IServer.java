package interfaces;

import CollectionManager.CollectionManager;
import Organization.Organization;

import java.net.SocketAddress;

public interface IServer {
    void send(SocketAddress address, IClientPacket packet);
    CollectionManager getCollectionManager();
    void setOrganization(Organization organization);
    Organization getOrganization();
    SocketAddress getAddress();
}
