// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.runtime;

/**
 Issued when execution context is destroyed.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface ExecutionContextDestroyedEventData {
  /**
   Id of the destroyed context
   */
  long/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.runtime.ExecutionContextIdTypedef*/ executionContextId();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.runtime.ExecutionContextDestroyedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.runtime.ExecutionContextDestroyedEventData>("Runtime.executionContextDestroyed", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.runtime.ExecutionContextDestroyedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.runtime.ExecutionContextDestroyedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parseRuntimeExecutionContextDestroyedEventData(obj);
    }
  };
}
