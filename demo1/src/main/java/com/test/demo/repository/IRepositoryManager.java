package com.test.demo.repository;

import javax.jcr.RepositoryException;

public interface IRepositoryManager extends IWorkspaceManager {

    String EXCEL_TEMPLATES_FOLDER = "excelTemplate";
	String EMAIL_TEMPLATES_FOLDER = "emailTemplate";
    /**
	 * start the repository connector
	 */
	public void start();

	/**
	 * stop the repository connector
	 */
	public void stop();

	@Deprecated
	public void registerListenr(String name, IRepositoryManagerListener listener);

	/**
	 * check if the repository is connected
	 * 
	 * @return
	 */
	public boolean isConnected();

	/**
	 * connect to the repository server
	 * 
	 * @throws RepositoryException
	 */
	public void connect() throws RepositoryException;

	public IWorkspaceManager getWorkspaceManager(String workspace);

}
