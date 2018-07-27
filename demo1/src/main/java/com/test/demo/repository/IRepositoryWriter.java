package com.test.demo.repository;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

public interface IRepositoryWriter {
	public void write(Session session) throws RepositoryException;
}
