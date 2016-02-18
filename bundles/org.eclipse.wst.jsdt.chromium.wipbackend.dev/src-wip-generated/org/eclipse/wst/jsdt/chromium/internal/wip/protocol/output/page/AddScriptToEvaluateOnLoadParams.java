// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.page;

public class AddScriptToEvaluateOnLoadParams extends org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.WipParamsWithResponse<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.AddScriptToEvaluateOnLoadData> {
  public AddScriptToEvaluateOnLoadParams(String scriptSource) {
    this.put("scriptSource", scriptSource);
  }

  public static final String METHOD_NAME = org.eclipse.wst.jsdt.chromium.internal.wip.protocol.BasicConstants.Domain.PAGE + ".addScriptToEvaluateOnLoad";

  @Override protected String getRequestName() {
    return METHOD_NAME;
  }

  @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.AddScriptToEvaluateOnLoadData parseResponse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipCommandResponse.Data data, org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
    return parser.parsePageAddScriptToEvaluateOnLoadData(data.getUnderlyingObject());
  }

}
