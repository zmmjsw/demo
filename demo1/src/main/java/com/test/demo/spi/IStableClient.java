package com.test.demo.spi;

import java.io.Serializable;

import com.test.demo.exception.FailureException;
import com.test.demo.exception.TransformException;


/**
 * the status in host database will be updated when send success A job will try
 * to send the failed message(status not updated)
 * 
 * @author dha
 *
 */
public interface IStableClient extends IClient {
	/**
	 * send message to peer
	 * 
	 * @param obj
	 * @throws FailureException
	 */
	public void deliver(Serializable obj) throws FailureException;

	public boolean checkValid(Object message, boolean fromJob);

	default public void sendMessage(Object message, boolean fromJob)
			throws TransformException, FailureException {
		if (checkValid(message, fromJob)) {
			sendMessage(message);
		}
	}
}
