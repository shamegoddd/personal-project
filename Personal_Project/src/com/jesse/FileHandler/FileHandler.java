package com.jesse.FileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jesse.StatisticUtils.StatisticUtils;

public class FileHandler {
	
	private StatisticUtils su = new StatisticUtils();

	public boolean isFileExist(String path) throws IOException {
		File file = new File(path);
       

        if(file.isFile()){
           return true;

        }
        else {
        	return false;
        }

	}

	public void FileStatistic(String path, String option) throws IOException {
		switch (option) {
		case "-l":
			su.LineNum(path);
			break;
		case "-c":
			su.CharNum(path);
			break;
		case "-w":
			su.WordNum(path);
			break;
		case "-a":
			su.MultiNum(path);
			break;
		default:
			break;
		}
        
		
	}

}
