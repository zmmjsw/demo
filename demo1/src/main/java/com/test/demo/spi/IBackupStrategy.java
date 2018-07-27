package com.test.demo.spi;

import java.io.Serializable;

public interface IBackupStrategy {
	public void backup(IMessageType messageType, Serializable request, Serializable response);
	
	public void backup(IMessageType messageType, Serializable request);
}
