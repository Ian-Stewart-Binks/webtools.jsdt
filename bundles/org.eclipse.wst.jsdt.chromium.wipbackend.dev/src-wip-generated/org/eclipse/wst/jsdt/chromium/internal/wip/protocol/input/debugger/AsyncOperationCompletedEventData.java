// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger;

/**
 Fired when an async operation is completed (while in a debugger stepping session).
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface AsyncOperationCompletedEventData {
  /**
   ID of the async operation that was completed.
   */
  long id();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.AsyncOperationCompletedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.AsyncOperationCompletedEventData>("Debugger.asyncOperationCompleted", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.AsyncOperationCompletedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.AsyncOperationCompletedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parseDebuggerAsyncOperationCompletedEventData(obj);
    }
  };
}
