package lbe.model.flow.impl;

import lbe.model.flow.FlowSource;

public class SimpleFlowSource extends FlowSource {

	private final String name;

	public SimpleFlowSource(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}
