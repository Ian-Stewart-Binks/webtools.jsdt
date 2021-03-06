// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://svn.webkit.org/repository/webkit/trunk/Source/WebCore/inspector/Inspector.json@102140

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.runtime;

/**
Evaluates expression on global object.
 */
public class EvaluateParams extends org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.WipParamsWithResponse<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.runtime.EvaluateData> {
  /**
   @param expression Expression to evaluate.
   @param objectGroupOpt Symbolic group name that can be used to release multiple objects.
   @param includeCommandLineAPIOpt Determines whether Command Line API should be available during the evaluation.
   @param doNotPauseOnExceptionsOpt Specifies whether evaluation should stop on exceptions. Overrides setPauseOnException state.
   @param frameIdOpt Specifies in which frame to perform evaluation.
   @param returnByValueOpt Whether the result is expected to be a JSON object that should be sent by value.
   */
  public EvaluateParams(String expression, String objectGroupOpt, Boolean includeCommandLineAPIOpt, Boolean doNotPauseOnExceptionsOpt, String/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.network.FrameIdTypedef*/ frameIdOpt, Boolean returnByValueOpt) {
    this.put("expression", expression);
    if (objectGroupOpt != null) {
      this.put("objectGroup", objectGroupOpt);
    }
    if (includeCommandLineAPIOpt != null) {
      this.put("includeCommandLineAPI", includeCommandLineAPIOpt);
    }
    if (doNotPauseOnExceptionsOpt != null) {
      this.put("doNotPauseOnExceptions", doNotPauseOnExceptionsOpt);
    }
    if (frameIdOpt != null) {
      this.put("frameId", frameIdOpt);
    }
    if (returnByValueOpt != null) {
      this.put("returnByValue", returnByValueOpt);
    }
  }

  public static final String METHOD_NAME = org.eclipse.wst.jsdt.chromium.internal.wip.protocol.BasicConstants.Domain.RUNTIME + ".evaluate";

  @Override protected String getRequestName() {
    return METHOD_NAME;
  }

  @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.runtime.EvaluateData parseResponse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipCommandResponse.Data data, org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
    return parser.parseRuntimeEvaluateData(data.getUnderlyingObject());
  }

}
