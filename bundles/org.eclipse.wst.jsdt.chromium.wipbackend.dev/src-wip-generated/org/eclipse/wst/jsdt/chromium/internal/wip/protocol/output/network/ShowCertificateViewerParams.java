// Generated source.
// Generator: org.eclipse.wst.jsdt.chromium.internal.wip.tools.protocolgenerator.Generator
// Origin: http://src.chromium.org/blink/trunk/Source/devtools/protocol.json@<unknown>

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.network;

/**
Displays native dialog with the certificate details.
 */
public class ShowCertificateViewerParams extends org.eclipse.wst.jsdt.chromium.internal.wip.protocol.output.WipParams {
  /**
   @param certificateId Certificate id.
   */
  public ShowCertificateViewerParams(long/*See org.eclipse.wst.jsdt.chromium.internal.wip.protocol.common.network.CertificateIdTypedef*/ certificateId) {
    this.put("certificateId", certificateId);
  }

  public static final String METHOD_NAME = org.eclipse.wst.jsdt.chromium.internal.wip.protocol.BasicConstants.Domain.NETWORK + ".showCertificateViewer";

  @Override protected String getRequestName() {
    return METHOD_NAME;
  }

}
