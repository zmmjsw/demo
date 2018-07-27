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
@Component("TestIStableClient")
public class TestIStableClient implements IStableClient{

	@Override
	public Serializable send(Serializable obj) throws FailureException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPeer getPeer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "test";
	}

	@Override
	public FileInfo serialize(Serializable message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable deserialize(FileInfo file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBackupStrategy getBackupStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IFailureStrategy getFailureStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable transformMessage(Object message) throws TransformException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deliver(Serializable obj) throws FailureException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkValid(Object message, boolean fromJob) {
		// TODO Auto-generated method stub
		return false;
	}

}
