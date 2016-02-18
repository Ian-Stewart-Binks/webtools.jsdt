// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom;

/**
 Called when shadow root is pushed into the element.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface ShadowRootPushedEventData {
  /**
   Host element id.
   */
  long/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.dom.NodeIdTypedef*/ hostId();

  /**
   Shadow root.
   */
  org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.NodeValue root();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.ShadowRootPushedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.ShadowRootPushedEventData>("DOM.shadowRootPushed", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.ShadowRootPushedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.ShadowRootPushedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parseDOMShadowRootPushedEventData(obj);
    }
  };
}
