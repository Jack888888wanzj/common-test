package com.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


/**
 * @�������ƣ�FileUtil
 * @˵�����ļ�������
 * @������: ��־��
 * @����ʱ��: 2019��8��1�� ����4:30:47
 * @�޸���: ��־��
 * @�޸�ʱ��: 2019��8��1�� ����4:30:47
 */

public class FileUtil {

	private static Logger log = Logger.getLogger(FileUtil.class);
	        /**
	 * @��������: unpack
	 * @˵��: 	��ѹzip�ļ�
	 * @���� @param zipFilePath
	 * @���� @param outputDirPath
	 * @���� @param charsetName
	 * @�������� void    
	 * @������: ��־��  
	 * @����ʱ��: 2019��8��1�� ����4:34:41
	 * @�޸���: ��־��  
	 * @�޸�ʱ��: 2019��8��1�� ����4:34:41        
	        */   
	    
	public static void unpack(String zipFilePath, String outputDirPath, String charsetName) {

		File zip = new File(zipFilePath);
		File outputDir = new File(outputDirPath);
		FileOutputStream out = null;
		InputStream in = null;
		// �����ļ�����
		ZipFile zipFileData = null;
		ZipFile zipFile = null;
		try {
			// ��Ŀ�걣���ļ�λ�ò�����
			if (outputDir != null)
				if (!outputDir.exists()) {
					outputDir.mkdirs();
				}
			if (charsetName != null && charsetName != "") {
				zipFile = new ZipFile(zip.getPath(), Charset.forName(charsetName));
			} else {
				zipFile = new ZipFile(zip.getPath(), Charset.forName("utf8"));
			}
			// zipFile = new ZipFile(zip.getPath(), Charset.forName(charsetName));
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			// �������ļ���
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				String filePath = "";

				if (outputDir == null) {
					filePath = zip.getParentFile().getPath() + File.separator + entry.getName();
				} else {
					filePath = outputDir.getPath() + File.separator + entry.getName();
				}
				File file = new File(filePath);
				File parentFile = file.getParentFile();
				if (!parentFile.exists()) {
					parentFile.mkdirs();
				}
				if (parentFile.isDirectory()) {
					continue;
				}
			}
			if (charsetName != null && charsetName != "") {
				zipFileData = new ZipFile(zip.getPath(), Charset.forName(charsetName));
			} else {
				zipFileData = new ZipFile(zip.getPath(), Charset.forName("utf8"));
			}
			Enumeration<? extends ZipEntry> entriesData = zipFileData.entries();
			while (entriesData.hasMoreElements()) {
				ZipEntry entry = entriesData.nextElement();
				in = zipFile.getInputStream(entry);
				String filePath = "";
				if (outputDir == null) {
					filePath = zip.getParentFile().getPath() + File.separator + entry.getName();
				} else {
					filePath = outputDir.getPath() + File.separator + entry.getName();
				}
				File file = new File(filePath);
				if (file.isDirectory()) {
					continue;
				}
				out = new FileOutputStream(filePath);
				int len = -1;
				byte[] bytes = new byte[1024];
				while ((len = in.read(bytes)) != -1) {
					out.write(bytes, 0, len);
				}
				out.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				zipFile.close();
				zipFileData.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	    /**
	* @��������: isExists
	* @˵��: 
	* @���� @param filePath
	* @���� @return
	* @�������� boolean    
	* @������: ��־��  
	* @����ʱ��: 2019��11��7�� ����11:16:30
	* @�޸���: ��־��  
	* @�޸�ʱ��: 2019��11��7�� ����11:16:30        
	       */   
	   
	public static boolean isExists(String filePath)
	{
		if(StringUtils.isEmpty(filePath))
		{
			log.error("param--��filePath is null ��");
			return false;
		}
		File file = new File(filePath);
		if(file.exists())
			return true;
		return  false;
	}
}

