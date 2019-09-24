import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;

import com.jesse.FileArgsFilter.FileArgsFilter;




public class UserTest {
	 

	public static void main(String[] args) throws IOException {
		FileArgsFilter filter = new FileArgsFilter();
			String path="E:\\test\\test.java";
			String option="-a";
			if (filter.isArgsLegal(path,option)){
				filter.FileStatistic(path, option);
			}
			else 
				System.err.println("please enter again!");
		
		
	}

}
