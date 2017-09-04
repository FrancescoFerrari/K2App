package com.k2.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.k2.dao.UploadedFileDao;
import com.k2.entity.UploadedFile;
import com.k2.exception.ServiceException;

@Service
@Transactional
public class UploadedFileServiceImplementation implements UploadedFileService {

	@Autowired
	private UploadedFileDao UploadedFileDAO;

	public void setUploadedFileDao(UploadedFileDao UploadedFileDAO) {
		this.UploadedFileDAO = UploadedFileDAO;
	}

	
	
	@Override
	@Transactional
	public void addUploadedFile(UploadedFile p) throws ServiceException {
		this.UploadedFileDAO.addUploadedFile(p);		
	}

	@Override
	@Transactional
	public void updateUploadedFile(UploadedFile p) throws ServiceException {
		this.UploadedFileDAO.updateUploadedFile(p);
	}

	@Override
	@Transactional
	public List<UploadedFile> listUploadedFile() throws ServiceException {
		return this.UploadedFileDAO.listUploadedFile();
	}

	@Override
	@Transactional
	public UploadedFile getUploadedFileById(long id) throws ServiceException {
		return this.UploadedFileDAO.getUploadedFileById(id);
	}

	@Override
	@Transactional
	public void removeUploadedFile(long id) throws ServiceException {
		this.UploadedFileDAO.removeUploadedFile(id);
	}

}
