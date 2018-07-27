package com.test.demo.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.demo.repository.FileInfo;
import com.test.demo.repository.IRepositoryManager;

import javax.jcr.RepositoryException;
import java.io.Serializable;

public class ZPMCBackupStrategy implements IBackupStrategy {

	private Logger logger = LoggerFactory.getLogger(IBackupStrategy.class);

	public static final String BACKUP = "backup";

	private IRepositoryManager rm;

	public ZPMCBackupStrategy(IRepositoryManager rm) {
		this.rm = rm;
	}

	public void backup(String peer, String messageType, FileInfo file) {
		String path = BACKUP + IRepositoryManager.SEPERATOR + peer
				+ IRepositoryManager.SEPERATOR + messageType;
		try {
			logger.debug("Store backup message {} to {}", file.getName(), path);
			rm.writeFile(path, file, true);
		} catch (RepositoryException e) {
			logger.error(e.getMessage(), e);
		}
	}


    @Override
    public void backup(IMessageType messageType, Serializable request) {

    }

    @Override
	public void backup(IMessageType message, Serializable request,
			Serializable response) {

        String peerName = message.getPeer().getName();
        String messageType = message.getName();
        FileInfo file = message.serialize(request);
        FileInfo fileResponse = message.serialize(response);
        backup(peerName, messageType, file);
        backup(peerName, messageType, fileResponse);
	}
}
