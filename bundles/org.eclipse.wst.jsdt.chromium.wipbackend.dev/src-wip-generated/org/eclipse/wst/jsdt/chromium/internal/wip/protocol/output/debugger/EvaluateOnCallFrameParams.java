// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.debugger;

/**
Evaluates expression on a given call frame.
 */
public class EvaluateOnCallFrameParams extends org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.WipParamsWithResponse<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.EvaluateOnCallFrameData> {
  /**
   @param callFrameId Call frame identifier to evaluate on.
   @param expression Expression to evaluate.
   @param objectGroupOpt String object group name to put result into (allows rapid releasing resulting object handles using <code>releaseObjectGroup</code>).
   @param includeCommandLineAPIOpt Specifies whether command line API should be available to the evaluated expression, defaults to false.
   @param doNotPauseOnExceptionsAndMuteConsoleOpt Specifies whether evaluation should stop on exceptions and mute console. Overrides setPauseOnException state.
   @param returnByValueOpt Whether the result is expected to be a JSON object that should be sent by value.
   @param generatePreviewOpt Whether preview should be generated for the result.
   */
  public EvaluateOnCallFrameParams(String/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.debugger.CallFrameIdTypedef*/ callFrameId, String expression, String objectGroupOpt, Boolean includeCommandLineAPIOpt, Boolean doNotPauseOnExceptionsAndMuteConsoleOpt, Boolean returnByValueOpt, Boolean generatePreviewOpt) {
    this.put("callFrameId", callFrameId);
    this.put("expression", expression);
    if (objectGroupOpt != null) {
      this.put("objectGroup", objectGroupOpt);
    }
    if (includeCommandLineAPIOpt != null) {
      this.put("includeCommandLineAPI", includeCommandLineAPIOpt);
    }
    if (doNotPauseOnExceptionsAndMuteConsoleOpt != null) {
      this.put("doNotPauseOnExceptionsAndMuteConsole", doNotPauseOnExceptionsAndMuteConsoleOpt);
    }
    if (returnByValueOpt != null) {
      this.put("returnByValue", returnByValueOpt);
    }
    if (generatePreviewOpt != null) {
      this.put("generatePreview", generatePreviewOpt);
    }
  }

  public static final String METHOD_NAME = org.eclipse.wst.jsdt.chromium.internal.wip.protocol.BasicConstants.Domain.DEBUGGER + ".evaluateOnCallFrame";

  @Override protected String getRequestName() {
    return METHOD_NAME;
  }

  @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.debugger.EvaluateOnCallFrameData parseResponse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipCommandResponse.Data data, org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
    return parser.parseDebuggerEvaluateOnCallFrameData(data.getUnderlyingObject());
  }

}
