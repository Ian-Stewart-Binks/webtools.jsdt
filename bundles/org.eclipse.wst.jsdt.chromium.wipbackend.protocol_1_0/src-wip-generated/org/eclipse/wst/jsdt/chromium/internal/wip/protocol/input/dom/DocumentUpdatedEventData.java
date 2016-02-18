// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://svn.webkit.org/repository/webkit/trunk/Source/WebCore/inspector/Inspector.json@96703

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom;

/**
 Fired when <code>Document</code> has been totally updated. Node ids are no longer valid.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface DocumentUpdatedEventData {
  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.DocumentUpdatedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.DocumentUpdatedEventData>("DOM.documentUpdated", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.DocumentUpdatedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom.DocumentUpdatedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parseDOMDocumentUpdatedEventData(obj);
    }
  };
}
