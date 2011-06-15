package lbe.model.flow.impl;

import lbe.model.flow.FlowSink;
import lbe.model.flow.FlowSource;

public class SimpleFlowSink extends FlowSink {

	private final String name;

	public SimpleFlowSink(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}
