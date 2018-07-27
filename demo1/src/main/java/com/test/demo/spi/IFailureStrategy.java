package com.test.demo.spi;

import java.io.Serializable;

public interface IFailureStrategy {
	public boolean rethrowFailure();

	public Serializable handleFailure(IMessageType client, Serializable request);

	public Serializable handleFailure(IMessageType client,
			Serializable request, Serializable response);

	public Serializable handleFailure(IMessageType client,
			Serializable request, Serializable response, Exception e);
}
