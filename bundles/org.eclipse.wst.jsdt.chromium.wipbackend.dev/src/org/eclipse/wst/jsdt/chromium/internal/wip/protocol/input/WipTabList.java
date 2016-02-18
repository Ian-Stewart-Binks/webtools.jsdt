// Copyright (c) 2011 The Chromium Authors. All rights reserved.
// This program and the accompanying materials are made available
// under the terms of the Eclipse Public License v1.0 which accompanies
// this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html

package org.eclipse.wst.jsdt.chromium.internal.wip.protocol.input;

import java.util.List;

import org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonOptionalField;
import org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonProtocolParseException;
import org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonSubtypeCasting;
import org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType;

@JsonType(subtypesChosenManually=true)
public interface WipTabList {
  @JsonSubtypeCasting List<TabDescription> asTabList() throws JsonProtocolParseException;

  @JsonType interface TabDescription {
    String id();
    
    @JsonOptionalField
    String parentId();
    
    @JsonOptionalField
    String faviconUrl();
    
    String title();
    
    String url();

    @JsonOptionalField
    String thumbnailUrl();

    // TODO: consider adding enum here
    String type();

    @JsonOptionalField
    String description();

    @JsonOptionalField
    String devtoolsFrontendUrl();

    @JsonOptionalField
    String webSocketDebuggerUrl();
  }
}
