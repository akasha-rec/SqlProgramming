package fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUtil {
	//파일 업로드
	public static String uploadFile(HttpServletRequest req, String sDirectory) throws ServletException, IOException {
		Part part = req.getPart("ofile");
		String partHeader = part.getHeader("content-disposition");
		String[] phArr = partHeader.split("filename=");
		String originalFileName = phArr[1].trim().replace("\"", "");
		if (!originalFileName.isEmpty()) {
			part.write(sDirectory+ File.separator +originalFileName);
		}
		return originalFileName;
	}
	//파일명 변경
	public static String renameFile(String sDirectory, String fileName) {
		String ext = fileName.substring(fileName.lastIndexOf("."));
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
		String newFileName = now + ext;
		File oldFile = new File(sDirectory + File.separator + fileName); 
		File newFile = new File(sDirectory + File.separator + newFileName);
		oldFile.renameTo(newFile);
		
		return newFileName;
	}
	
	public static ArrayList<String> multipleFile(HttpServletRequest req, String sDirectory) throws ServletException, IOException {
		
		ArrayList<String> listFileName = new ArrayList<>();
		Collection<Part> parts = req.getParts(); //전송된 폼값을 받아 > Collection<Part>반환 > for문으로 개수만큼 반복 가능
		for(Part part : parts) {
			if (!part.getName().equals("ofile"))//ofile이 첨부하는데 사용되는 name 속성이므로 나머지는 저장X > continue
				continue;
			
			String partHeader = part.getHeader("content-disposition");
			String[] phArr = partHeader.split("filename=");
			String originalFileName = phArr[1].trim().replace("\"", "");
			if (!originalFileName.isEmpty()) {
				part.write(sDirectory+ File.separator +originalFileName);
			}
			listFileName.add(originalFileName);
		}
		return listFileName;
	}
}
