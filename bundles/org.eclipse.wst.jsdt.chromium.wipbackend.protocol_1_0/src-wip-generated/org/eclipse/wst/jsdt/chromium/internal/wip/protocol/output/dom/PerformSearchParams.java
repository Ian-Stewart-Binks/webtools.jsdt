// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://svn.webkit.org/repository/webkit/trunk/Source/WebCore/inspector/Inspector.json@101756

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.dom;

/**
Searches for a given string in the DOM tree. Use <code>getSearchResults</code> to access search results or <code>cancelSearch</code> to end this search session.
 */
public class PerformSearchParams extends org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.WipParamsWithResponse<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.PerformSearchData> {
  /**
   @param query Plain text or query selector or XPath search query.
   */
  public PerformSearchParams(String query) {
    this.put("query", query);
  }

  public static final String METHOD_NAME = org.eclipse.wst.jsdt.chromium.internal.wip.protocol.BasicConstants.Domain.DOM + ".performSearch";

  @Override protected String getRequestName() {
    return METHOD_NAME;
  }

  @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.PerformSearchData parseResponse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipCommandResponse.Data data, org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
    return parser.parseDOMPerformSearchData(data.getUnderlyingObject());
  }

}
