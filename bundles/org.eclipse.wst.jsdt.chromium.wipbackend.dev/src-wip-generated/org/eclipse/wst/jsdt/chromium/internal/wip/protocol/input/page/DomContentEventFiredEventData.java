// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page;

@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface DomContentEventFiredEventData {
  Number timestamp();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.DomContentEventFiredEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.DomContentEventFiredEventData>("Page.domContentEventFired", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.DomContentEventFiredEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page.DomContentEventFiredEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parsePageDomContentEventFiredEventData(obj);
    }
  };
}
