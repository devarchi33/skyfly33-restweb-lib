package test.skyfly33.openapi.naver;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import junit.framework.TestCase;
import skyfly33.openapi.naver.RankValue;
import skyfly33.openapi.naver.SearchHandler;

public class TestSearchHandler extends TestCase
{
	public void test() throws Exception
	{
		SearchHandler handler = new SearchHandler();
		File file = new File("./search.xml");

		FileInputStream fis = new FileInputStream(file);
		ArrayList<RankValue> rankList = handler.parseDocument(fis);

		for (int i = 0; rankList != null && i < rankList.size(); i++)
		{
			System.out.println(rankList.get(i).toString());
		}
	}
}
