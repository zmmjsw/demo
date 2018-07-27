package com.test.demo.spi;

import java.io.Serializable;

import com.test.demo.exception.TransformException;
import com.test.demo.repository.FileInfo;

public interface IMessageType {
	public static final String SEPERATOR = ".";

	public IPeer getPeer();

	public String getName();

	public FileInfo serialize(Serializable message);

	public Serializable deserialize(FileInfo file);

	public IBackupStrategy getBackupStrategy();

	public IFailureStrategy getFailureStrategy();

	/**
	 * transform the message to be sent
	 * 
	 * @param message
	 * @return
	 * @throws TransformException
	 */
	public Serializable transformMessage(Object message)
			throws TransformException;

	default public String getFullName() {
		try {
			return getPeer().getName() + SEPERATOR + getName();
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"No peer/service definition for " + getClass().getName());
		}
	}

}
