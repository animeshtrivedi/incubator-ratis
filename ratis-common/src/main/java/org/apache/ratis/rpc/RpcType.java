/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.ratis.rpc;

import org.apache.ratis.conf.Parameters;
import org.apache.ratis.util.ReflectionUtils;

/** The type of RPC implementations. */
public interface RpcType {
  /**
   * Parse the given string as a {@link SupportedRpcType}
   * or a user-defined {@link RpcType}.
   *
   * @param rpcType The string representation of an {@link RpcType}.
   * @return a {@link SupportedRpcType} or a user-defined {@link RpcType}.
   */
  static RpcType valueOf(String rpcType) {
    final Throwable fromSupportedRpcType;
    try { // Try parsing it as a SupportedRpcType
      return SupportedRpcType.valueOfIgnoreCase(rpcType);
    } catch (Throwable t) {
      fromSupportedRpcType = t;
    }

    try {
      // Try using it as a class name
      return ReflectionUtils.newInstance(
          ReflectionUtils.getClass(rpcType, RpcType.class));
    } catch(Throwable t) {
      final IllegalArgumentException iae = new IllegalArgumentException(
          "Invalid " + RpcType.class.getSimpleName() + ": \"" + rpcType + "\" "
              + " cannot be used as a user-defined " + RpcType.class.getSimpleName()
              + " and it is not a " + SupportedRpcType.class.getSimpleName() + ".");
      iae.addSuppressed(t);
      iae.addSuppressed(fromSupportedRpcType);
      throw iae;
    }
  }

  /** @return the name of the rpc type. */
  String name();

  /** @return a new factory created using the given properties and parameters. */
  RpcFactory newFactory(Parameters parameters);

  /** An interface to get {@link RpcType}. */
  interface Get {
    /** @return the {@link RpcType}. */
    RpcType getRpcType();
  }
}