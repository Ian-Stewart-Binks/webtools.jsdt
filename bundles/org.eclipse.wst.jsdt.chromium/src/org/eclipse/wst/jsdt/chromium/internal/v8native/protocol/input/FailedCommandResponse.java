// Copyright (c) 2009 The Chromium Authors. All rights reserved.
// This program and the accompanying materials are made available
// under the terms of the Eclipse Public License v1.0 which accompanies
// this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html

package org.eclipse.wst.jsdt.chromium.internal.v8native.protocol.input;

import org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonField;
import org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonOptionalField;
import org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonOverrideField;
import org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonSubtype;
import org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonSubtypeCasting;
import org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonSubtypeConditionBoolValue;
import org.eclipse.wst.jsdt.chromium.internal.protocolparser.JsonType;

/**
 * A type for failed command response message. It should contain "message" field
 * hinting at the cause of the failure.
 */
@JsonType
public interface FailedCommandResponse extends JsonSubtype<CommandResponse> {
  @JsonOverrideField
  @JsonSubtypeConditionBoolValue(false)
  boolean success();

  String message();

  @JsonField(jsonLiteralName="request_seq")
  Long requestSeq();

  @JsonOptionalField
  String command();

  @JsonField(jsonLiteralName="error_details")
  @JsonOptionalField
  ErrorDetails errorDetails();

  @JsonType
  interface ErrorDetails {
    Type type();

    @JsonSubtypeCasting
    ChangeLiveBody.CompileErrorDetails asChangeLiveCompileError();

    enum Type {
      LIVEEDIT_COMPILE_ERROR
    }
  }
}
