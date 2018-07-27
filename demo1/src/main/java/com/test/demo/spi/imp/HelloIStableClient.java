package com.test.demo.spi.imp;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.test.demo.exception.FailureException;
import com.test.demo.exception.TransformException;
import com.test.demo.repository.FileInfo;
import com.test.demo.spi.IBackupStrategy;
import com.test.demo.spi.IFailureStrategy;
import com.test.demo.spi.IPeer;
import com.test.demo.spi.IStableClient;
@Component("HelloIStableClient")
public class HelloIStableClient implements IStableClient{

	@Override
	public Serializable send(Serializable obj) throws FailureException {
		return null;
	}

	@Override
	public IPeer getPeer() {
		return null;
	}

	@Override
	public String getName() {
		return "hehe";
	}

	@Override
	public FileInfo serialize(Serializable message) {
		return null;
	}

	@Override
	public Serializable deserialize(FileInfo file) {
		return null;
	}

	@Override
	public IBackupStrategy getBackupStrategy() {
		return null;
	}

	@Override
	public IFailureStrategy getFailureStrategy() {
		return null;
	}

	@Override
	public Serializable transformMessage(Object message) throws TransformException {
		return null;
	}

	@Override
	public void deliver(Serializable obj) throws FailureException {
		
	}

	@Override
	public boolean checkValid(Object message, boolean fromJob) {
		return false;
	}

}
