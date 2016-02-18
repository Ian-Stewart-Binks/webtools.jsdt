// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.dom;

/**
 A structure holding an RGBA color.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface RGBAValue {
  /**
   The red component, in the [0-255] range.
   */
  long r();

  /**
   The green component, in the [0-255] range.
   */
  long g();

  /**
   The blue component, in the [0-255] range.
   */
  long b();

  /**
   The alpha component, in the [0-1] range (default: 1).
   */
  @org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonOptionalField
  Number a();

}
