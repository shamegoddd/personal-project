package com.jesse.FileArgsFilter;

import java.io.File;
import java.io.IOException;

import com.jesse.FileHandler.FileHandler;




/**
 * 
 * Module for arguments containing File's path and options filter, which 
 * makes sure arguments transfered in right format.
 *
 */
public class FileArgsFilter {
	//
	private String [] options = {"-l","-c","-w","-a"};
	private FileHandler filehandler = new FileHandler();
	//judge if arguments legal 
	public boolean isArgsLegal(String path , String option) throws IOException{
		
		if (path==null||option==null){
			System.err.println("Path or option is empty");
			return false;
		}
		else{
			for(String s: options){
		        if(s.equals(option)){
		            if (filehandler.isFileExist(path)){
		            	return true;
		            }
		            
		        }
		    }
			System.err.println("Wrong options!");
			return false;
		}
		
	}
	
	public void FileStatistic(String path,String option) throws IOException{
		filehandler.FileStatistic(path, option);
	}
	
}
