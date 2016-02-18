// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.page;

/**
Navigates current page to the given history entry.
 */
public class NavigateToHistoryEntryParams extends org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.WipParams {
  /**
   @param entryId Unique id of the entry to navigate to.
   */
  public NavigateToHistoryEntryParams(long entryId) {
    this.put("entryId", entryId);
  }

  public static final String METHOD_NAME = org.eclipse.wst.jsdt.chromium.internal.wip.protocol.BasicConstants.Domain.PAGE + ".navigateToHistoryEntry";

  @Override protected String getRequestName() {
    return METHOD_NAME;
  }

}
