package test.skyfly33.openapi.naver;

import junit.framework.TestCase;

import java.util.Hashtable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import skyfly33.openapi.naver.HttpFactory;

public class TestHttpFactory extends TestCase {

	//HttpFactory�� createGet() �޼ҵ带 �׽�Ʈ�ϱ� ���� �޼ҵ�
	public void testCreateGet(){
		Hashtable<String, String> params = HttpFactory.createDefaultParam();
		
		try {
			HttpGet getMethod = HttpFactory.createGet(params);
			System.out.println(getMethod.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//HttpFactory�� createPost() �޼ҵ带 �׽�Ʈ�ϱ� ���� �޼ҵ�
	public void testCreatePost() {
		Hashtable<String, String> params = HttpFactory.createDefaultParam();
		InputStream is = null;
		InputStreamReader reader = null;
		BufferedReader br = null;
		try {
			HttpPost postMethod = HttpFactory.createPost(params);
			System.out.println(postMethod.toString());
			
			is = postMethod.getEntity().getContent();
			br = new BufferedReader(new InputStreamReader(is));
			
			String line = null;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(br != null)
					br.close();
				if(reader != null)
					reader.close();
				if(is!=null)
					is.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
