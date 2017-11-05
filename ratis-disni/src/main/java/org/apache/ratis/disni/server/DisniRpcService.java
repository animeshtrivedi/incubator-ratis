package org.apache.ratis.disni.server;

import org.apache.ratis.protocol.RaftPeer;
import org.apache.ratis.rpc.RpcType;
import org.apache.ratis.server.RaftServerRpc;
import org.apache.ratis.shaded.proto.RaftProtos;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by atr on 05.11.17.
 */
public class DisniRpcService implements RaftServerRpc {
  @Override
  public RaftProtos.RequestVoteReplyProto requestVote(RaftProtos.RequestVoteRequestProto request) throws IOException {
    return null;
  }

  @Override
  public RaftProtos.AppendEntriesReplyProto appendEntries(RaftProtos.AppendEntriesRequestProto request) throws IOException {
    return null;
  }

  @Override
  public RaftProtos.InstallSnapshotReplyProto installSnapshot(RaftProtos.InstallSnapshotRequestProto request) throws IOException {
    return null;
  }

  @Override
  public void start() {

  }

  @Override
  public InetSocketAddress getInetSocketAddress() {
    return null;
  }

  @Override
  public void addPeers(Iterable<RaftPeer> peers) {

  }

  @Override
  public void close() throws IOException {

  }

  @Override
  public RpcType getRpcType() {
    return null;
  }
}
