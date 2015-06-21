package test.skyfly33.openapi.naver;

import java.util.ArrayList;

import junit.framework.TestCase;
import skyfly33.openapi.naver.RankValue;
import skyfly33.openapi.naver.SearchClient;

public class TestSearchClient extends TestCase
{
	public void testGet() throws Exception
	{
		SearchClient client = new SearchClient();
		ArrayList<RankValue> rankList = client.get();
		for (int i = 0; rankList != null && i < rankList.size(); i++)
			System.out.println(rankList.get(i).toString());
	}

	public void testPost() throws Exception
	{
		SearchClient client = new SearchClient();
		ArrayList<RankValue> rankList = client.post();
		for (int i = 0; rankList != null && i < rankList.size(); i++)
			System.out.println(rankList.get(i).toString());
	}
}
