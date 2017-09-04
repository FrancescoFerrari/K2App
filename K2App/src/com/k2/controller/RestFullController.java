package com.k2.controller;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.k2.entity.Layer;
import com.k2.exception.ServiceException;
import com.k2.service.LayerService;
import com.k2.service.LayerServiceImpl;

/**
 *
 * @author mlucino
 */
@Controller
//@RestController //Per Spring 4
public class RestFullController {
    
    private LayerService layerService;
 
//    
//    @Autowired(required=true)
//    @Qualifier(value="layerService")
//    public void setLayerService(LayerServiceImpl ps){
//        this.layerService = ps;
//    }
//  
	@Inject
	public RestFullController(final LayerService layerService) {
		this.layerService = layerService;  
	}

    
    
    
    @RequestMapping(value = "/rest/code/{code}/{type}", method = RequestMethod.GET,headers="Accept=*/*" , produces = "application/json")//,headers="Accept=application/json" , produces = "application/json")
    @ExceptionHandler(ServiceException.class)
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody List<Layer> getLogsJSONUdid(@PathVariable("code") String codice, @PathVariable("type") Integer tipo)
    {
        List<Layer> layersList = new ArrayList<Layer>();
        try {
            layersList = this.layerService.getLayersBycodice(codice, tipo);
        } catch (ServiceException e) {
//            logger.error("ServiceException "+e.getMessage());
        } catch (Exception e) {
//            logger.error("Exception "+e.getMessage());
        }
        return layersList;
    }

    
//    //GET JSON FORMAT
//    @RequestMapping(value = "/rest/logs_json", method = RequestMethod.GET)//,headers="Accept=application/json", , produces = "application/json")
//    @ExceptionHandler(GenericException.class)
//    @Produces(MediaType.APPLICATION_JSON)
//    public @ResponseBody List<Log> getLogsJSON()
//    {
//        List<Log> logs = new ArrayList<Log>();
//        try {
//            logs = this.logService.getLogs();
//        } catch (ServiceException e) {
//            logger.error("ServiceException "+e.getMessage());
//        } catch (Exception e) {
//            logger.error("Exception "+e.getMessage());
//        }
//        return logs;
//    }
//    
//  
    
    
}
