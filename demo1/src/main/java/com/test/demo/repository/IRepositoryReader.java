package com.test.demo.repository;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

public interface IRepositoryReader {
	public Object read(Session session) throws RepositoryException;
}
