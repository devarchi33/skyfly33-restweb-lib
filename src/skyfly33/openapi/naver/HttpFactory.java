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
		
		//HttpGet 객체에 매개변수를 추가하기 위해서 사용하는 URIBuilder 클래스
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
		
		//매개변수 Params를 처리하여 POST 방식의 body에 데이터를 추가한다.
		ArrayList<NameValuePair> formParamList = new ArrayList<NameValuePair>();
		for (String paramName : params.keySet()) {
			formParamList.add(new BasicNameValuePair(paramName, params.get(paramName)));
		}
		
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParamList, "UTF-8");
		postMethod.setEntity(entity);

		return postMethod;
	}
	
	//네이버 openAPI를 호출하기 위해서 항상 key값이 HttpReuest 메세지에 포함되어야 함.
	//그래서 기본적으로 KEY값이 저장된 Hashtable 객체가 반환된다.
	public static Hashtable<String, String> createDefaultParam() {
		Hashtable<String, String> param = new Hashtable<String, String>();
		param.put(SearchConstants.PARAM_KEY_NAME, SearchConstants.PARAM_KEY_VALUE);
		return param;
	}
}
