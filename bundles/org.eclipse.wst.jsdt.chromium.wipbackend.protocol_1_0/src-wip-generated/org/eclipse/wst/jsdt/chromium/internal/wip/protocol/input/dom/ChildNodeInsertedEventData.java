// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://svn.webkit.org/repository/webkit/trunk/Source/WebCore/inspector/Inspector.json@102140

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom;

/**
 Mirrors <code>DOMNodeInserted</code> event.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface ChildNodeInsertedEventData {
  /**
   Id of the node that has changed.
   */
  long/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.dom.NodeIdTypedef*/ parentNodeId();

  /**
   If of the previous siblint.
   */
  long/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.dom.NodeIdTypedef*/ previousNodeId();

  /**
   Inserted node data.
   */
  org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.NodeValue node();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.ChildNodeInsertedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.ChildNodeInsertedEventData>("DOM.childNodeInserted", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.ChildNodeInsertedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.ChildNodeInsertedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parseDOMChildNodeInsertedEventData(obj);
    }
  };
}
