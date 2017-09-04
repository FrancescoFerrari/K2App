package com.k2.service;

import java.util.List;

import com.k2.entity.Layer;

public interface LayerService {
	public List<Layer> getRegioni();
	public List<Layer> getLayersBycodice(String codice, int tipo);

}
