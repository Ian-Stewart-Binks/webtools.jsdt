// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger;

/**
 Fired when breakpoint is resolved to an actual script and location.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface BreakpointResolvedEventData {
  /**
   Breakpoint unique identifier.
   */
  String/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.debugger.BreakpointIdTypedef*/ breakpointId();

  /**
   Actual breakpoint location.
   */
  org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.LocationValue location();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.BreakpointResolvedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.BreakpointResolvedEventData>("Debugger.breakpointResolved", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.BreakpointResolvedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.BreakpointResolvedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parseDebuggerBreakpointResolvedEventData(obj);
    }
  };
}
