package com.k2.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ControllerUF {

	
	
	
	
	@RequestMapping(value= "/upload", method = RequestMethod.POST)
	public String showResultForm(@ModelAttribute("ISTATLoader") MultipartFile ISTATLoader,
			ModelMap model) {

		model.addAttribute("ISTATLoader", ISTATLoader);

		try {	
				File serverFile=UploadFileInLocal(ISTATLoader);

				try {
					moveToHDFS(serverFile);
					return "/result_form";

				}catch (Exception e) {
					e.printStackTrace();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return "/form";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	private File UploadFileInLocal(MultipartFile file) throws IOException {


		byte[] bytes = file.getBytes();

		String directory = "/home/hadoop-user/eclipse-workspace-Spring/K2App/WebContent/uploads";
		File directoryfile = new File(directory);

		if (!directoryfile.exists())
			directoryfile.mkdirs() ;

		// Create the file on server 
		File serverFile = new File(directoryfile.getAbsolutePath()+ File.separator + file.getOriginalFilename());
		BufferedOutputStream streamPopulation = new BufferedOutputStream(new FileOutputStream(serverFile));
		
		streamPopulation.write(bytes);
		streamPopulation.close();
		
		return serverFile;			
	}


	
	private void moveToHDFS(File serverFile) throws IOException, URISyntaxException {

		Configuration conf = HBaseConfiguration.create();
		FileSystem hdfs = FileSystem.get(new URI("hdfs://localhost:9000"),conf);

		Path localFilePath = new Path(serverFile.getAbsolutePath());
		Path hdfsFilePath = new Path("hdfs://localhost:9000/user/hadoop-user/K2App/"+serverFile.getName());


		hdfs.copyFromLocalFile(localFilePath, hdfsFilePath);	

	}
	
	
	
	
	
	
	
	
	public ControllerUF() {
	}

}
