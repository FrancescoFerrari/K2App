package com.k2.dao;

import java.util.List;


import com.k2.entity.UploadedFile;
import com.k2.exception.ServiceException;

public interface UploadedFileDao {


	public void addUploadedFile(UploadedFile p) throws ServiceException;
	public void updateUploadedFile(UploadedFile p) throws ServiceException;
	public List<UploadedFile> listUploadedFile() throws ServiceException;
	public UploadedFile getUploadedFileById(long id) throws ServiceException;
	public void removeUploadedFile(long id) throws ServiceException;

}
