/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.jsdt.debug.internal.rhino.jsdi.event;

import org.eclipse.wst.jsdt.debug.core.jsdi.Location;
import org.eclipse.wst.jsdt.debug.core.jsdi.ThreadReference;
import org.eclipse.wst.jsdt.debug.core.jsdi.event.StepEvent;
import org.eclipse.wst.jsdt.debug.core.jsdi.request.StepRequest;
import org.eclipse.wst.jsdt.debug.internal.rhino.jsdi.VirtualMachineImpl;

public class StepEventImpl extends EventImpl implements StepEvent {

	private final ThreadReference thread;
	private final Location location;

	public StepEventImpl(VirtualMachineImpl vm, ThreadReference thread, Location location, StepRequest request) {
		super(vm, request);
		this.thread = thread;
		this.location = location;
	}

	public ThreadReference thread() {
		return thread;
	}

	public Location location() {
		return location;
	}
}
