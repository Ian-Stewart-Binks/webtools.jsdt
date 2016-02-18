// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.page;

/**
Paints viewport size upon main frame resize.
 */
public class SetShowViewportSizeOnResizeParams extends org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.WipParams {
  /**
   @param show Whether to paint size or not.
   @param showGridOpt Whether to paint grid as well.
   */
  public SetShowViewportSizeOnResizeParams(boolean show, Boolean showGridOpt) {
    this.put("show", show);
    if (showGridOpt != null) {
      this.put("showGrid", showGridOpt);
    }
  }

  public static final String METHOD_NAME = org.eclipse.wst.jsdt.chromium.internal.wip.protocol.BasicConstants.Domain.PAGE + ".setShowViewportSizeOnResize";

  @Override protected String getRequestName() {
    return METHOD_NAME;
  }

}
