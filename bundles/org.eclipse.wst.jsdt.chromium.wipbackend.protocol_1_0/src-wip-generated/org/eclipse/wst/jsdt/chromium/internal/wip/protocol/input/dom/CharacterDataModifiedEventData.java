// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://svn.webkit.org/repository/webkit/trunk/Source/WebCore/inspector/Inspector.json@102140

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom;

/**
 Mirrors <code>DOMCharacterDataModified</code> event.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface CharacterDataModifiedEventData {
  /**
   Id of the node that has changed.
   */
  long/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.dom.NodeIdTypedef*/ nodeId();

  /**
   New text value.
   */
  String characterData();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.CharacterDataModifiedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.CharacterDataModifiedEventData>("DOM.characterDataModified", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.CharacterDataModifiedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.CharacterDataModifiedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parseDOMCharacterDataModifiedEventData(obj);
    }
  };
}
