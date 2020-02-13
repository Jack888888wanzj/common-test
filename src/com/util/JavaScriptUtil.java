package com.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

 
        /**
 * @�������ƣ�JavaScriptUtil
 * @˵����	js ����������
 * @������: ��־��  
 * @����ʱ��: 2020��1��7�� ����3:32:46
 * @�޸���: ��־��  
 * @�޸�ʱ��: 2020��1��7�� ����3:32:46 
        */  
    
public class JavaScriptUtil {

	
	private static ScriptEngine se;
	private static Logger log = Logger.getLogger(JavaScriptUtil.class.getName());
	
	//��ʼ��javascript����
	static {
		se = new ScriptEngineManager().getEngineByName("javascript");
		// des���ļ�λ��
		InputStream is =  JavaScriptUtil.class.getResourceAsStream("/des.js");
		try {
			se.eval(new InputStreamReader(is));
		} catch (ScriptException e) {
			log.error("---javascript����   ��ʼ���쳣-----", e.getCause());
		}
		
	}
	        /**
	 * @��������: encrypt
	 * @˵��:  Ĭ��des.js��class·�����ļ������ʹ���������Map
	 * @���� @param param
	 * @���� @return
	 * @���� @throws FileNotFoundException
	 * @���� @throws ScriptException
	 * @���� @throws IOException
	 * @���� @throws NoSuchMethodException
	 * @�������� String    
	 * @������: ��־��  
	 * @����ʱ��: 2020��1��7�� ����3:33:33
	 * @�޸���: ��־��  
	 * @�޸�ʱ��: 2020��1��7�� ����3:33:33        
	        */   
	    
	public static String encrypt(Map param) throws FileNotFoundException, ScriptException, IOException, NoSuchMethodException {
		String encryResult = "";
		if (se instanceof Invocable) {
			Invocable invocable = (Invocable) se;
			String jsonParams = JSON.toJSONString(param);
			encryResult = (String) invocable.invokeFunction("encrypt", jsonParams, "888888");
		}
		return encryResult;
	}
	
	 
	        /**
	 * @��������: ���ݴ���
	 * @˵��:  ���ʹ���������Map��JS�ļ���ַ��class·������class��des.js�ļ�����δ���des.js��
	 * @���� @param param
	 * @���� @param jsAddr
	 * @���� @return
	 * @���� @throws FileNotFoundException
	 * @���� @throws ScriptException
	 * @���� @throws IOException
	 * @���� @throws NoSuchMethodException
	 * @�������� String    
	 * @������: ��־��  
	 * @����ʱ��: 2020��1��7�� ����3:36:33
	 * @�޸���: ��־��  
	 * @�޸�ʱ��: 2020��1��7�� ����3:36:33        
	        */   
	    
	public static String encrypt(Map param,String jsAddr) throws FileNotFoundException, ScriptException, IOException, NoSuchMethodException {
		String encryResult = "";
		InputStream is =  JavaScriptUtil.class.getResourceAsStream(new StringBuilder("/").append(jsAddr).toString());
		se.eval(new InputStreamReader(is));
		if (se instanceof Invocable) {
			Invocable invocable = (Invocable) se;
			String jsonParams = JSON.toJSONString(param);
			encryResult = (String) invocable.invokeFunction("encrypt", jsonParams, "888888");
			System.out.println(encryResult);
		}
		return encryResult;
	}
	
	
	
	public static String execFunc(String funcionName,String jsAddr,Object... param) throws FileNotFoundException, ScriptException, IOException, NoSuchMethodException {
		String execResult = "";
		/*org.springframework.core.io.Resource desJs2 = new ClassPathResource(jsAddr);
		se.eval(new FileReader(desJs2.getFile()));*/
		InputStream is =  JavaScriptUtil.class.getResourceAsStream(new StringBuilder("/").append(jsAddr).toString());
		se.eval(new InputStreamReader(is));
		if (se instanceof Invocable) {
			Invocable invocable = (Invocable) se;
			execResult = (String) invocable.invokeFunction(funcionName, param);
			System.out.println(execResult);
		}
		return execResult;
	}
	
	public static void main(String args[])
	{
		Map param = new HashMap();
		param.put("aa", "hello World");
		try {
			String result =encrypt(param);
			System.out.print(result);
		} catch (NoSuchMethodException | ScriptException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
