// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://svn.webkit.org/repository/webkit/trunk/Source/WebCore/inspector/Inspector.json@102140

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.page;

/**
Returns content of the given resource.
 */
public class GetResourceContentParams extends org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.WipParamsWithResponse<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.GetResourceContentData> {
  /**
   @param frameId Frame id to get resource for.
   @param url URL of the resource to get content for.
   */
  public GetResourceContentParams(String/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.network.FrameIdTypedef*/ frameId, String url) {
    this.put("frameId", frameId);
    this.put("url", url);
  }

  public static final String METHOD_NAME = org.eclipse.wst.jsdt.chromium.internal.wip.protocol.BasicConstants.Domain.PAGE + ".getResourceContent";

  @Override protected String getRequestName() {
    return METHOD_NAME;
  }

  @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.GetResourceContentData parseResponse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipCommandResponse.Data data, org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
    return parser.parsePageGetResourceContentData(data.getUnderlyingObject());
  }

}
