package com.test.demo.repository;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface IWorkspaceManager {

	public static final String SEPERATOR = "/";

	// create folder
	public void createFolder(String path) throws RepositoryException;

	public void createFolder(String path, Map<String, Object> props)
			throws RepositoryException;

	// delete node
	public void deleteNode(String pathToName) throws RepositoryException;

	public void deleteNode(String path, String name) throws RepositoryException;

	// check node exist
	public boolean checkNodeExist(String path) throws RepositoryException;

	public boolean checkNodeExist(String path, String name)
			throws RepositoryException;

	// count nodes
	public long countNodes(String path) throws RepositoryException;

	// list nodes
	public List<HierarchyNodeInfo> listNodes(String path)
			throws RepositoryException;

	public List<HierarchyNodeInfo> listNodes(String path, long offset,
			long limit) throws RepositoryException;

	// write file
	public void writeFile(final String path, final String mimeType,
			final String name, final InputStream is, final boolean createFolder)
			throws RepositoryException;

	public void writeFile(final String path, final String mimeType,
			final String name, final InputStream is) throws RepositoryException;

	public void writeFile(final String path, final String name,
			final String encoding, final String mimeType, final InputStream is,
			final Map<String, Object> properties) throws RepositoryException;

	public void writeFile(final String path, final FileInfo fileInfo)
			throws RepositoryException;

	public void writeFile(final String path, final FileInfo fileInfo,
			boolean createPath) throws RepositoryException;

	// read file
	public FileInfo readFile(final String pathToName)
			throws RepositoryException;

	public FileInfo readFile(final String path, final String name,
			boolean localized) throws RepositoryException;

	public FileInfo readFile(final String path, final String name)
			throws RepositoryException;

	public Object doRead(IRepositoryReader reader) throws RepositoryException;

	public void doWrite(IRepositoryWriter writer) throws RepositoryException;

	public Session createSession() throws RepositoryException;

	public void destroySession(Session session) throws RepositoryException;

	public void copy(String fromPath, String toPath) throws RepositoryException;
}
