// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.security;

/**
 The security state of the page changed.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface SecurityStateChangedEventData {
  /**
   Security state.
   */
  org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.security.SecurityStateEnum securityState();

  /**
   List of explanations for the security state. If the overall security state is `insecure` or `warning`, at least one corresponding explanation should be included.
   */
  @org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonOptionalField
  java.util.List<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.security.SecurityStateExplanationValue> explanations();

  /**
   Information about mixed content on the page.
   */
  @org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonOptionalField
  org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.security.MixedContentStatusValue mixedContentStatus();

  /**
   True if the page was loaded over cryptographic transport such as HTTPS.
   */
  @org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonOptionalField
  Boolean schemeIsCryptographic();

  public static final org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.security.SecurityStateChangedEventData> TYPE
      = new org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipEventType<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.security.SecurityStateChangedEventData>("Security.securityStateChanged", org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.security.SecurityStateChangedEventData.class) {
    @Override public org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.security.SecurityStateChangedEventData parse(org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.WipGeneratedParserRoot parser, org.json.simple.JSONObject obj) throws org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException {
      return parser.parseSecuritySecurityStateChangedEventData(obj);
    }
  };
}
