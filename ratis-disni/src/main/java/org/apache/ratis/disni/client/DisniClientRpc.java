package org.apache.ratis.disni.client;

import org.apache.ratis.client.RaftClientRpc;
import org.apache.ratis.protocol.RaftClientReply;
import org.apache.ratis.protocol.RaftClientRequest;
import org.apache.ratis.protocol.RaftPeer;
import org.apache.ratis.protocol.RaftPeerId;

import java.io.IOException;

/**
 * Created by atr on 05.11.17.
 */
public class DisniClientRpc implements RaftClientRpc {
  @Override
  public RaftClientReply sendRequest(RaftClientRequest request) throws IOException {
    return null;
  }

  @Override
  public void addServers(Iterable<RaftPeer> servers) {

  }

  @Override
  public void handleException(RaftPeerId serverId, Exception e) {

  }

  @Override
  public void close() throws IOException {

  }
}
