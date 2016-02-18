// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.network;

/**
 Fired when EventSource message is received.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface EventSourceMessageReceivedEventData {
  /**
   Request identifier.
   */
  String/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.network.RequestIdTypedef*/ requestId();

  /**
   Timestamp.
   */
  Number/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.network.TimestampTypedef*/ timestamp();

  /**
   Message type.
   */
  String eventName();

  /**
   Message identifier.
   */
  String eventId();

  /**
   Message content.
   */
  String data();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.network.EventSourceMessageReceivedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.network.EventSourceMessageReceivedEventData>("Network.eventSourceMessageReceived", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.network.EventSourceMessageReceivedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.network.EventSourceMessageReceivedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parseNetworkEventSourceMessageReceivedEventData(obj);
    }
  };
}
