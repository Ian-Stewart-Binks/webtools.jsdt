// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://svn.webkit.org/repository/webkit/trunk/Source/WebCore/inspector/Inspector.json@96703

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.network;

/**
 Timing information for the request.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface ResourceTimingValue {
  /**
   Timing's requestTime is a baseline in seconds, while the other numbers are ticks in milliseconds relatively to this requestTime.
   */
  Number requestTime();

  /**
   Started resolving proxy.
   */
  Number proxyStart();

  /**
   Finished resolving proxy.
   */
  Number proxyEnd();

  /**
   Started DNS address resolve.
   */
  Number dnsStart();

  /**
   Finished DNS address resolve.
   */
  Number dnsEnd();

  /**
   Started connecting to the remote host.
   */
  Number connectStart();

  /**
   Connected to the remote host.
   */
  Number connectEnd();

  /**
   Started SSL handshake.
   */
  Number sslStart();

  /**
   Finished SSL handshake.
   */
  Number sslEnd();

  /**
   Started sending request.
   */
  Number sendStart();

  /**
   Finished sending request.
   */
  Number sendEnd();

  /**
   Finished receiving response headers.
   */
  Number receiveHeadersEnd();

}
