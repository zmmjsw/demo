package com.test.demo.spi;

import java.io.Serializable;

import com.test.demo.exception.FailureException;
import com.test.demo.exception.TransformException;


public interface IClient extends IMessageType {
	/**
	 * send message to peer, update the current status in host db if required
	 *
	 * @param obj
	 * @return
	 * @throws FailureException
	 */
	public Serializable send(Serializable obj) throws FailureException;

	/**
	 * transform the message then send
	 *
	 * @param message
	 * @throws TransformException
	 * @throws FailureException
	 */
	default public Serializable sendMessage(Object message)
			throws TransformException, FailureException {
		IFailureStrategy strategy = getFailureStrategy();
		Serializable obj = transformMessage(message);
		IBackupStrategy backupStrategy = getBackupStrategy();
		Serializable result = null;
		try {
			result = send(obj);
			if (backupStrategy != null) {
				backupStrategy.backup(this, obj, result);
			}
			return result;
		} catch (Exception e) {
			if (strategy != null) {
				result = strategy.handleFailure(this, obj,
						(Serializable) result, e);
				if (strategy.rethrowFailure()) {
					throw e;
				}
				return result;
			} else {
				throw e;
			}
		}

	}
}
