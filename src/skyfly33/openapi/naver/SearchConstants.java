package skyfly33.openapi.naver;

import skyfly33.util.Config;

public interface SearchConstants {

	//OpenAPI 정보를 위한 상수들
	public final static String API_PROTOCOL = "http";
	public final static String API_HOST = "openapi.naver.com";
	public final static String API_PATH = "/search";
	public final static int API_PORT = 80;
	
	//OpenAPI 키에 대한 상수들
	public final static String PARAM_KEY_NAME = "key";
	public final static String PARAM_KEY_VALUE = Config.getInstance().getProperties("naver.search.key");
	
	//매개변수를 위한 상수들
	public final static String PARAM_TARGET_NAME = "target";
	public final static String PARAM_TARGET_RANK = "rank";
	
	public final static String PARAM_QUERY_NAME = "query";
	public final static String PARAM_QUERY_ALL = "nexearch";
}
