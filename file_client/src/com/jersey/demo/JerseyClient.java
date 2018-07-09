package com.jersey.demo;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import org.apache.commons.io.FileUtils;

import com.jersey.utils.FileNameCreator;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class JerseyClient {

	public static void main(String[] args) throws IOException {
		// Ҫ�ϴ����ļ�
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		
		// ͼƬ���Ƶ�������
		String url = FileNameCreator.creatRandomName("http://localhost:8080/file_server/upload/", file.getName());
		// jersey client
		Client client = new Client();
		// ��������·��
		WebResource resource = client.resource(url);
		// ���ļ�ת��Ϊbyte����
		byte[] buf = FileUtils.readFileToByteArray(file);
		//����
		resource.put(String.class,buf);
		System.out.println("���ͳɹ�");
	}
}
