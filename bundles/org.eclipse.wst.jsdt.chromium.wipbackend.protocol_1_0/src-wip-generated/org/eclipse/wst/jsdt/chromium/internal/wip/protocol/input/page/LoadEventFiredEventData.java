// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://svn.webkit.org/repository/webkit/!svn/bc/92284/trunk/Source/WebCore/inspector/Inspector.json@92284

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page;

@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface LoadEventFiredEventData {
  Number timestamp();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.LoadEventFiredEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.LoadEventFiredEventData>("Page.loadEventFired", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.LoadEventFiredEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.LoadEventFiredEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parsePageLoadEventFiredEventData(obj);
    }
  };
}
