package skyfly33.openapi.naver;

import java.net.URI;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;


public class HttpFactory {

	public static  HttpGet createGet(Hashtable<String, String> params) throws Exception {
		
		if(params == null){
			throw new IllegalArgumentException("Param is null");
		}
		
		//HttpGet ��ü�� �Ű������� �߰��ϱ� ���ؼ� ����ϴ� URIBuilder Ŭ����
		URIBuilder builder = new URIBuilder();
		builder.setScheme(SearchConstants.API_PROTOCOL);
		builder.setHost(SearchConstants.API_HOST);
		builder.setPath(SearchConstants.API_PATH);
		
		for (String paramName : params.keySet()) {
			builder.setParameter(paramName, params.get(paramName));
		}
		
		HttpGet httpGet= new HttpGet(builder.build());
		
//		List<NameValuePair> paramsList = builder.getQueryParams();
		
		return httpGet;
	}
	
	public static HttpPost createPost(Hashtable<String, String> params) throws Exception	{
		
		if(params == null){
			throw new IllegalArgumentException("Param is null");
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(SearchConstants.API_PROTOCOL).append("://");
		sb.append(SearchConstants.API_HOST).append(":").append(SearchConstants.API_PORT);
		sb.append(SearchConstants.API_PATH);
		HttpPost postMethod = new HttpPost(new URI(sb.toString()));
		
		//�Ű����� Params�� ó���Ͽ� POST ����� body�� �����͸� �߰��Ѵ�.
		ArrayList<NameValuePair> formParamList = new ArrayList<NameValuePair>();
		for (String paramName : params.keySet()) {
			formParamList.add(new BasicNameValuePair(paramName, params.get(paramName)));
		}
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParamList, "UTF-8");
		postMethod.setEntity(entity);

		return postMethod;
	}
	
	//���̹� openAPI�� ȣ���ϱ� ���ؼ� �׻� key���� HttpReuest �޼����� ���ԵǾ�� ��.
	//�׷��� �⺻������ KEY���� ����� Hashtable ��ü�� ��ȯ�ȴ�.
	public static Hashtable<String, String> createDefaultParam() {
		Hashtable<String, String> param = new Hashtable<String, String>();
		param.put(SearchConstants.PARAM_KEY_NAME, SearchConstants.PARAM_KEY_VALUE);
		return param;
	}
}
