package org.apache.ratis.disni;

import org.apache.ratis.client.ClientFactory;
import org.apache.ratis.conf.Parameters;
import org.apache.ratis.disni.client.DisniClientRpc;
import org.apache.ratis.disni.server.DisniRpcService;
import org.apache.ratis.protocol.ClientId;
import org.apache.ratis.rpc.SupportedRpcType;
import org.apache.ratis.server.RaftServer;
import org.apache.ratis.server.impl.ServerFactory;

/**
 * Created by atr on 05.11.17.
 */
public class DisniFactory extends ServerFactory.BaseFactory implements ClientFactory {

  public DisniFactory(Parameters parameters) {

  }

  @Override
  public SupportedRpcType getRpcType() {
    return SupportedRpcType.DISNI;
  }

  @Override
  public DisniRpcService newRaftServerRpc(RaftServer server) {
    return null;
  }

  @Override
  public DisniClientRpc newRaftClientRpc(ClientId clientId) {
    return null;
  }
}
