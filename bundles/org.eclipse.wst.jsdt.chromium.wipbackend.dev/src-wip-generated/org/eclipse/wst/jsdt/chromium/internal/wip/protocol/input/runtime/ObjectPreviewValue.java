// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.runtime;

/**
 Object containing abbreviated remote object value.
 */
@org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType
public interface ObjectPreviewValue {
  /**
   Object type.
   */
  Type type();

  /**
   Object subtype hint. Specified for <code>object</code> type values only.
   */
  @org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonOptionalField
  Subtype subtype();

  /**
   String representation of the object.
   */
  @org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonOptionalField
  String description();

  /**
   Determines whether preview is lossless (contains all information of the original object).
   */
  boolean lossless();

  /**
   True iff some of the properties or entries of the original object did not fit.
   */
  boolean overflow();

  /**
   List of the properties.
   */
  java.util.List<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.runtime.PropertyPreviewValue> properties();

  /**
   List of the entries. Specified for <code>map</code> and <code>set</code> subtype values only.
   */
  @org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonOptionalField
  java.util.List<org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input.runtime.EntryPreviewValue> entries();

  /**
   Object type.
   */
  public enum Type {
    OBJECT,
    FUNCTION,
    UNDEFINED,
    STRING,
    NUMBER,
    BOOLEAN,
    SYMBOL,
  }
  /**
   Object subtype hint. Specified for <code>object</code> type values only.
   */
  public enum Subtype {
    ARRAY,
    NULL,
    NODE,
    REGEXP,
    DATE,
    MAP,
    SET,
    ITERATOR,
    GENERATOR,
    ERROR,
  }
}
