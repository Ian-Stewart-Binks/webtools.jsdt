// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://svn.webkit.org/repository/webkit/trunk/Source/WebCore/inspector/Inspector.json@101756

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page;

/**
 Fired once navigation of the frame has completed. Frame is now associated with the new loader.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface FrameNavigatedEventData {
  /**
   Frame object.
   */
  org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.FrameValue frame();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.FrameNavigatedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.FrameNavigatedEventData>("Page.frameNavigated", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.FrameNavigatedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.FrameNavigatedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parsePageFrameNavigatedEventData(obj);
    }
  };
}
