package com.jesse.StatisticUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * this module includes four functions to handle four kind of various options
 *
 */
public class StatisticUtils {

	public void LineNum(String path) throws IOException {
		File file = new File(path);
		InputStream inputStream = new FileInputStream(file);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        int totalLine=0;
        while((reader.readLine())!=null){
            totalLine++;
        }

        //¹Ø±ÕÁ÷
        reader.close();
        inputStream.close();
        System.out.println("Number of Line:"+totalLine);
		
	}

	public void CharNum(String path) throws IOException {
		File file = new File(path);

            InputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int charNum = 0;
            String line=null;
            while((line=reader.readLine())!=null){
                //replace all blank space to empty so the characters is constant
                line = line.replaceAll("\\s", "");
                
                charNum += line.length();
            }

           
            reader.close();
            inputStream.close();
            System.out.println("Number of Characters:"+charNum);
       
		
	}

	public void WordNum(String path) throws IOException {
			File file = new File(path);
        
            InputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int wordNum=0;
            String word=null;
            //regular expression to match word and do iteration
            Pattern pattern = Pattern.compile("\\b[a-zA-Z]+\\b");
            Matcher m=null;
            while((word = reader.readLine())!=null){
            	m = pattern.matcher(word);
                
                while(m.find()){
                	wordNum++;
                }
            }

            reader.close();
            inputStream.close();
            System.out.println("Number of word:"+wordNum);
         
		
	}

	public void MultiNum(String path) throws IOException {
        int codeLine = 0;
		int totalLine=0;
		int explanationLine=0;
		int emptyLine = 0;
        boolean isStart = false;//mark if block(/*)start 
        int startLine = 0;//mark number of line of block 
        	File file = new File(path);
            InputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line=reader.readLine())!=null){
                totalLine++;
                line = line.replaceAll("\\s", "");

                if(line.equals("")||line.equals("{")||line.equals("}")){
                    emptyLine++;
                }else if (line.startsWith("//")||line.startsWith("}//")||line.startsWith("{//")){
                    explanationLine++;
                }else if(line.startsWith("/*")){
                    isStart=true;
                    if(totalLine>startLine&&startLine==0){//if the block has '/*' but the block is not end with */,then change the startLine
                        startLine = totalLine;
                    }
                }else if(line.startsWith("*/")){
                        explanationLine += totalLine - startLine+1;
                        isStart=false;
                        startLine=0;
                }

            }

            reader.close();
            inputStream.close();
            System.out.println("Number of Code Line:"+(totalLine-explanationLine-emptyLine));
            System.out.println("Number of Explanation Line:"+explanationLine);
            System.out.println("Number of empty line:"+emptyLine);
		
	}

}
