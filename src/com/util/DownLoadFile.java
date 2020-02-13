package com.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

 
	/**
	* @�������ƣ�DownLoadFile
	* @˵�����ļ����ع�����
	* @������: ��־��  
	* @����ʱ��: 2019��7��26�� ����10:21:31
	* @�޸���: ��־��  
	* @�޸�ʱ��: 2019��7��26�� ����10:21:31 
    */  
    
public class DownLoadFile{

	private static Logger logger = Logger.getLogger(DownLoadFile.class);
	
            /**
     * @��������: downLoadFromUrl
     * @˵��: 	������Url�������ļ����贫���ļ����������ַ 
     * @���� @param urlStr
     * @���� @param fileName
     * @���� @param savePath
     * @���� @throws IOException
     * @�������� void    
     * @������: ��־��  
     * @����ʱ��: 2019��7��26�� ����10:21:51
     * @�޸���: ��־��  
     * @�޸�ʱ��: 2019��7��26�� ����10:21:51        
            */   
        
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{
        URL url = new URL(urlStr);  
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
                //���ó�ʱ��Ϊ3��
        conn.setConnectTimeout(3*1000);
        //��ֹ���γ���ץȡ������403����
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //�õ�������
        InputStream inputStream = conn.getInputStream();  
        //��ȡ�Լ�����
        byte[] getData = readInputStream(inputStream);
        
        logger.info(getData.length+"");
        
        //�ļ�����λ��
        File saveDir = new File(savePath);
        if(!saveDir.exists() || !saveDir.isDirectory()){
            saveDir.mkdirs();
        }
        File file = new File(saveDir+File.separator+fileName);  
        logger.info(file.getPath());
        
        FileOutputStream fos = new FileOutputStream(file);     
        fos.write(getData); 
        
        if(fos!=null){
            fos.close();  
        }
        if(inputStream!=null){
            inputStream.close();
        }
        logger.info("�ļ�����info:"+url+" download success ��");

    }
    

    
     
            /**
     * @��������: downLoadFromUrl
     * @˵��: ������Url�������ļ���
     * @���� @param urlStr
     * @���� @param savePath
     * @���� @throws IOException
     * @�������� void    
     * @������: ��־��  
     * @����ʱ��: 2019��7��26�� ����2:45:07
     * @�޸���: ��־��  
     * @�޸�ʱ��: 2019��7��26�� ����2:45:07        
            */   
        
    public static void  downLoadFromUrl(String urlStr,String savePath) throws IOException{
        URL url = new URL(urlStr);  
       
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
                //���ó�ʱ��Ϊ3��
        conn.setConnectTimeout(3*1000);
        //��ֹ���γ���ץȡ������403����
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //�õ�������
        InputStream inputStream = conn.getInputStream();  
        //��ȡ�Լ�����
        byte[] getData = readInputStream(inputStream);    
        logger.info(getData.length+"");
        //�ļ�����λ��
        File saveDir = new File(savePath);
        if(!saveDir.exists() || !saveDir.isDirectory() ){
            saveDir.mkdirs();
        }
        //��ȡURL�ļ���
        String fileName = null;
        fileName =  FilenameUtils.getName(urlStr);
        
        if(fileName==null || fileName.isEmpty() ||(fileName !=null && fileName.indexOf("?")>-1))
        {//	����ʱ�����ָ�����ļ����ͣ��������ļ���
//        	fileName = getFileName(GlobalsControl.getGlobals().getProperty("volice.downloadFileType"));
        	fileName = getFileName("mp3");
        }
        
        File file = new File(saveDir+File.separator+fileName);  
        
        logger.info(file.getPath());
        FileOutputStream fos = new FileOutputStream(file);     
        fos.write(getData); 
       
        if(fos!=null){
            fos.close();  
        }
        if(inputStream!=null){
            inputStream.close();
        }
        logger.info("�ļ�����info:"+url+" download success ��"); 

    }

            /**
     * @��������: readInputStream
     * @˵��: ���������л�ȡ�ֽ�����
     * @���� @param inputStream
     * @���� @return
     * @���� @throws IOException
     * @�������� byte[]    
     * @������: ��־��  
     * @����ʱ��: 2019��7��26�� ����10:26:33
     * @�޸���: ��־��  
     * @�޸�ʱ��: 2019��7��26�� ����10:26:33        
            */   
        
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        while((len = inputStream.read(buffer)) != -1) {  
            bos.write(buffer, 0, len);  
        }  
        bos.close();  
        return bos.toByteArray();  
    }  
    
     
            /**
     * @��������: getFileName
     * @˵��: 	��ʱ�������ָ����ʽ���ļ���
     * @���� @param fileType
     * @���� @return
     * @�������� String    
     * @������: ��־��  
     * @����ʱ��: 2019��7��26�� ����10:26:55
     * @�޸���: ��־��  
     * @�޸�ʱ��: 2019��7��26�� ����10:26:55        
            */   
        
    public static  String getFileName(String fileType) {
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    	String timeStamp = simpleDateFormat.format(new Date());
    	timeStamp = timeStamp+"."+fileType;
    	return timeStamp;
    }
     
            /**
     * @��������: downLoadFromUrl2
     * @˵��: ������Url�������ļ���
     * @���� @param urlStr
     * @���� @param savePath
     * @���� @throws IOException
     * @�������� void    
     * @������: ��־��  
     * @����ʱ��: 2019��11��21�� ����1:56:27
     * @�޸���: ��־��  
     * @�޸�ʱ��: 2019��11��21�� ����1:56:27        
            */   
        
    public static void  downLoadFromUrl2(String urlStr,String savePath) throws IOException{
        URL url = new URL(urlStr);  
       
        //�ļ�����λ��
        File saveDir = new File(savePath);
        if(!saveDir.exists() || !saveDir.isDirectory() ){
            saveDir.mkdirs();
        }
        //��ȡURL�ļ���
        String fileName = null;
        fileName =  FilenameUtils.getName(urlStr);
        
        if(fileName==null || fileName.isEmpty() ||(fileName !=null && fileName.indexOf("?")>-1))
        {//	����ʱ�����ָ�����ļ����ͣ��������ļ���
//        	fileName = getFileName(GlobalsControl.getGlobals().getProperty("volice.downloadFileType"));
        	fileName = getFileName("mp3");
        	
        }
        
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        
        FileOutputStream fileOutputStream = new FileOutputStream(new StringBuilder(savePath).append("/").append(fileName).toString());
        FileChannel fileChannel = fileOutputStream.getChannel();
        fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        
       
        if(fileOutputStream!=null){
        	fileOutputStream.close();  
        }
        if(readableByteChannel!=null){
        	readableByteChannel.close();
        }
        logger.info("�ļ�����info:"+url+" download success ��"); 
    }
    
     
            /**
     * @��������: batchDownloadFromFile
     * @˵��: ����filePath�е��ļ���ַ�����ļ������������������ļ�
     * @���� @param filePath
     * @���� @param savePath
     * @�������� void    
     * @������: ��־��  
     * @����ʱ��: 2019��11��21�� ����1:50:01
     * @�޸���: ��־��  
     * @�޸�ʱ��: 2019��11��21�� ����1:50:01        
            */   
        
    public static void batchDownloadFromFile(String filePath,String savePath)
    {
    	if(StringUtils.isEmpty(filePath))
    	{
    		logger.error("�������ļ���ַ��");
    		return;
    	}
    	if(StringUtils.isEmpty(savePath))
    	{
//    		savePath=GlobalsControl.getGlobals().getProperty("volice.downloadPath");
    		logger.error("�������ļ��洢��ַ��");
    		return;
    	}
    	try {
    		FileReader fr = new FileReader(filePath);
			List<String> fileAddrs = IOUtils.readLines(fr);
			int threadCount = 20;
			int perNum = fileAddrs.size()/threadCount;
			List<threadDownloadFile> threadPool = new ArrayList();
			long now = System.currentTimeMillis();
			for(int i=0;i<threadCount;i++)
			{
				int startIndex  = perNum*i;
				int endIndex = startIndex+perNum;
				if(i==threadCount-1)
					endIndex = fileAddrs.size();
				List<String> fileAddr = fileAddrs.subList(startIndex, endIndex);
				threadDownloadFile tdlf = new threadDownloadFile(fileAddr,savePath);
				threadPool.add(tdlf);
				tdlf.start();
			}
			while(true)
			{
				for(int i=0;i<threadPool.size();i++)
				{
					if(!threadPool.get(i).isAlive())
					{
						threadPool.remove(threadPool.get(i));
					}
				}
				if(threadPool.isEmpty() ||threadPool ==null)
					break;
			}
			long end = System.currentTimeMillis();
			System.out.println("��ʱ���룩��"+(end-now)/1000);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
     
            /**
     * @�������ƣ�threadDownloadFile
     * @˵�������߳�ִ����������
     * @������: ��־��  
     * @����ʱ��: 2019��11��21�� ����1:55:26
     * @�޸���: ��־��  
     * @�޸�ʱ��: 2019��11��21�� ����1:55:26 
            */  
        
    static class threadDownloadFile extends Thread  {
   	 
    	private List<String> fileAddrs;
    	private String savePath;
    	
    	threadDownloadFile(List<String> fileAddrs,String savePath) {
    		this.fileAddrs =fileAddrs;
    		this.savePath = savePath;
    	}
    	@Override
    	public void run() {
    		 for(String fileAddr:fileAddrs)
    		 {
    			 try {
					downLoadFromUrl2(fileAddr, savePath);
				} catch (IOException e) {
					logger.error("¼���ļ�"+fileAddr+"�����쳣��"+e.getMessage());
				}
    		 }
    	}
    }
    
    
}

