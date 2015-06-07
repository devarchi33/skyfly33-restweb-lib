package skyfly33.restful;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;

public class restTest {
	public static void main(String[] args) 
	{
		//�ؿ�Ư�� > ���� ���� > ���������� REST API ȣ�� URL, (URL�� Ȩ������ DATA ���������� Ȯ�� ����.)
		//[������ /openapi/rest/���񽺸�/���۷��̼Ǹ�]���� ����.
		String apiUrl = "http://plus.kipris.or.kr/openapi/rest/ForeignPatentBibliographicService/bibliographicInfo";

		//�ش� ��ǰ ���� ����Ű. ȸ������ �� �ڵ� �߱޵Ǹ� �������������� Ȯ�� ����
		String accessKey = "Mad4tOdLVZ5oEvmCm9m6TF9Oyz/gmQCFEDy8/SHNVUo=";
		//�Է°� �����ȣ & �����ڵ�
		String literatureNumber = "198100001145A1";
		String countryCode = "WO";
		
		apiUrl += "?accessKey="+accessKey+"&literatureNumber="+literatureNumber+"&countryCode="+countryCode;
		
		try {
			//REST API URL�� �о��� ����� ����Ѵ�
			URL url = new URL(apiUrl);
			
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");	//���ڵ�
			BufferedReader reader = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();
			String line = null;
			String tmpStr = null;
			while((line = reader.readLine()) != null){
				tmpStr = line.toString();
				tmpStr = tmpStr.replaceAll(" ", "");
				
				if(!tmpStr.equals("")) buffer.append(line).append("\r\n");
			}
			reader.close();
			
			//REST API ��� ��.
			String xmlResult = buffer.toString();
			
			System.out.println("ForeignPatentBibliographicService/bibliographicInfo RESULT => " + xmlResult);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

