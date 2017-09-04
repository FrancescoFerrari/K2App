package com.k2.dao;

import java.util.List;

import com.k2.entity.Layer;
import com.k2.exception.ServiceException;

public interface LayerDao {
	

	public List<Layer> getRegioni();
	public List<Layer> getLayersBycodice(String codice, int tipo);
	public void addLayerFile(Layer p) throws ServiceException;
	public void updateLayerFile(Layer p) throws ServiceException;
	public List<Layer> listLayer() throws ServiceException;
	public Layer getLayerById(long id) throws ServiceException;
	public void removeLayer(long id) throws ServiceException;

}
