package com.sh.fileTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.sh.file.FileDAO;
import com.sh.file.FileDTO;
import com.sh.s8.Abstract;

public class FileTest extends Abstract{

	@Inject
	private FileDAO fileDAO;
	
	@Test
	public void fileInsert()throws Exception{
		FileDTO fileDTO = new FileDTO();
		fileDTO.setNum(101);
		fileDTO.setFname("fname");
		fileDTO.setOname("oname");
		
		FileDTO fileDTO2 = new FileDTO();
		fileDTO2.setNum(101);
		fileDTO2.setFname("2fname");
		fileDTO2.setOname("2Oname");
		
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		files.add(fileDTO2);
		files.add(fileDTO);
		
		int result = fileDAO.setWrite(files);
		
	}

}
