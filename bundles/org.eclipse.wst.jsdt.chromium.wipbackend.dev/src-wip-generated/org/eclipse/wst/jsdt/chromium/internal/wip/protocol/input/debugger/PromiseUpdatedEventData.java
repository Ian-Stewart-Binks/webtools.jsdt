// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger;

/**
 Fired when a <code>Promise</code> is created, updated or garbage collected.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface PromiseUpdatedEventData {
  /**
   Type of the event.
   */
  EventType eventType();

  /**
   Information about the updated <code>Promise</code>.
   */
  org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.PromiseDetailsValue promise();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.PromiseUpdatedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.PromiseUpdatedEventData>("Debugger.promiseUpdated", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.PromiseUpdatedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.PromiseUpdatedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parseDebuggerPromiseUpdatedEventData(obj);
    }
  };
  /**
   Type of the event.
   */
  public enum EventType {
    NEW,
    UPDATE,
    GC,
  }
}
