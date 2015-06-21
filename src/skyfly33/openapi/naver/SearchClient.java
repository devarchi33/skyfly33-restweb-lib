package skyfly33.openapi.naver;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class SearchClient
{
	public static Log logger = LogFactory.getLog(SearchClient.class);

	public ArrayList<RankValue> post() throws Exception
	{
		ArrayList<RankValue> rankList = null;
		Hashtable<String, String> param = HttpFactory.createDefaultParam();
		param.put(SearchConstants.PARAM_QUERY_NAME, SearchConstants.PARAM_QUERY_ALL);
		param.put(SearchConstants.PARAM_TARGET_NAME, SearchConstants.PARAM_TARGET_RANK);
		HttpPost postMethod = HttpFactory.createPost(param);

		HttpClient httpClient = new DefaultHttpClient();
		InputStream is = null;
		try
		{
			HttpResponse response = httpClient.execute(postMethod);
			logger.info(response.getStatusLine().toString());

			is = response.getEntity().getContent();

			SearchHandler xmlHandler = new SearchHandler();
			rankList = xmlHandler.parseDocument(is);
		}
		catch (Exception e)
		{
			logger.warn("Search Failure", e);
		}
		finally
		{
			try
			{
				if (is != null)
					is.close();
			}
			catch (IOException ignorable)
			{
			}
		}
		return rankList;
	}

	public ArrayList<RankValue> get() throws Exception
	{
		ArrayList<RankValue> rankList = null;
		Hashtable<String, String> param = HttpFactory.createDefaultParam();
		param.put(SearchConstants.PARAM_QUERY_NAME, SearchConstants.PARAM_QUERY_ALL);
		param.put(SearchConstants.PARAM_TARGET_NAME, SearchConstants.PARAM_TARGET_RANK);
		HttpGet getMethod = HttpFactory.createGet(param);

		HttpClient httpClient = new DefaultHttpClient();
		InputStream is = null;
		try
		{
			HttpResponse response = httpClient.execute(getMethod);
			logger.info(response.getStatusLine().toString());

			is = response.getEntity().getContent();

			SearchHandler xmlHandler = new SearchHandler();
			rankList = xmlHandler.parseDocument(is);
		}
		catch (Exception e)
		{
			logger.warn("Search Failure", e);
		}
		finally
		{
			try
			{
				if (is != null)
					is.close();
			}
			catch (IOException ignorable)
			{
			}
		}
		return rankList;
	}
}
