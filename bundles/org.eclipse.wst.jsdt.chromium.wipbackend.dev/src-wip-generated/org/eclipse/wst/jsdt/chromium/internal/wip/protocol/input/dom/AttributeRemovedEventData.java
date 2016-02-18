// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom;

/**
 Fired when <code>Element</code>'s attribute is removed.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface AttributeRemovedEventData {
  /**
   Id of the node that has changed.
   */
  long/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.dom.NodeIdTypedef*/ nodeId();

  /**
   A ttribute name.
   */
  String name();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.AttributeRemovedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.AttributeRemovedEventData>("DOM.attributeRemoved", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.AttributeRemovedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.AttributeRemovedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parseDOMAttributeRemovedEventData(obj);
    }
  };
}
