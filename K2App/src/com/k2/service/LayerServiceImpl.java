package com.k2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.k2.dao.LayerDao;
import com.k2.entity.Layer;

@Service
@Component("layerServiceImpl")
@Transactional
public class LayerServiceImpl implements LayerService{
	
	private LayerDao layerDao;
	
	@Autowired//(required=false)
	public void setLayerDao(LayerDao layerDao) {
		this.layerDao = layerDao;
	}

	
	
	@Override
	public List<Layer> getRegioni() {
		return this.layerDao.getRegioni();
	}

	@Override
	public List<Layer> getLayersBycodice(String codice, int tipo) {
		return this.layerDao.getLayersBycodice(codice, tipo);
	}

}
