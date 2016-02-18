// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://svn.webkit.org/repository/webkit/trunk/Source/WebCore/inspector/Inspector.json@102140

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page;

/**
 Fired when frame has been detached from its parent.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface FrameDetachedEventData {
  /**
   Id of the frame that has been detached.
   */
  String/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.network.FrameIdTypedef*/ frameId();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.FrameDetachedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.FrameDetachedEventData>("Page.frameDetached", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.FrameDetachedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.FrameDetachedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parsePageFrameDetachedEventData(obj);
    }
  };
}
