// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.dom;

/**
Sets node value for a node with given id.
 */
public class SetNodeValueParams extends org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.WipParams {
  /**
   @param nodeId Id of the node to set value for.
   @param value New node's value.
   */
  public SetNodeValueParams(long/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.dom.NodeIdTypedef*/ nodeId, String value) {
    this.put("nodeId", nodeId);
    this.put("value", value);
  }

  public static final String METHOD_NAME = org.eclipse.wst.jsdt.chromium.internal.wip.protocol.BasicConstants.Domain.DOM + ".setNodeValue";

  @Override protected String getRequestName() {
    return METHOD_NAME;
  }

}
