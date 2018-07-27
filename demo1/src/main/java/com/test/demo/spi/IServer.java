package com.test.demo.spi;


import java.io.Serializable;

import com.test.demo.exception.FailureException;
import com.test.demo.exception.TransformException;

public interface IServer extends IMessageType {
	/**
	 * receive message from peer
	 *
	 * @param obj
	 * @return
	 */
	public Object receive(Serializable obj) throws FailureException;

	/**
	 * transform the message then receive
	 *
	 * @param message
	 * @throws TransformException
	 * @throws FailureException
	 */
	default public Object receiveMessage(Object message)
			throws TransformException, FailureException {
		IFailureStrategy strategy = getFailureStrategy();
		Serializable obj = transformMessage(message);
		IBackupStrategy backupStrategy = getBackupStrategy();
		Object result = null;
		try {
			result = receive(obj);
			if (backupStrategy != null) {
                if(backupStrategy instanceof ZPMCBackupStrategy){
                    backupStrategy.backup(this,obj,(Serializable)result);
                }else{
				    backupStrategy.backup(this, obj);
                }
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
