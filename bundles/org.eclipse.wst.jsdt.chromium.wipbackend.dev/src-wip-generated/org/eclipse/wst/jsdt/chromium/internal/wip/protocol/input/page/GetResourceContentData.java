// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.page;

/**
 Returns content of the given resource.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface GetResourceContentData {
  /**
   Resource content.
   */
  String content();

  /**
   True, if content was served as base64.
   */
  boolean base64Encoded();

}
