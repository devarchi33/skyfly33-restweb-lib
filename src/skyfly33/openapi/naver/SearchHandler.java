package skyfly33.openapi.naver;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class SearchHandler extends DefaultHandler{

	private final String TAG_KEYWORD = "K";
	private final String TAG_VALUE = "V";
	private final String TAG_STEP = "S";
	private final String TAG_RANK_PREFIX = "R";
	
	private ArrayList<RankValue> rankList;
	private RankValue tempVo;
	private CharArrayWriter text;
	
	public SearchHandler() {
		rankList = new ArrayList<RankValue>();
		text = new CharArrayWriter();
	}
	
	public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) throws SAXException{
		if(qName.startsWith(TAG_RANK_PREFIX)){
			tempVo = new RankValue();
			tempVo.setRank(Integer.parseInt(qName.substring(1)));
		}
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		String str = getText();
		System.out.println(">>" + str);
		if(qName.startsWith(TAG_RANK_PREFIX)){
			rankList.add(tempVo);
		}
		else if(qName.equals(TAG_KEYWORD)){
			tempVo.setKeyword(str);
			resetText();
		}
		else if(qName.equals(TAG_STEP)){
			tempVo.setStep(str);
			resetText();
		}
		else if(qName.equals(TAG_VALUE)){
			tempVo.setValue(Integer.parseInt(str));
			resetText();
		}
	}
	
	public void characters(char[] ch, int offset, int length) throws SAXException {
		text.write(ch, offset, length);
	}
	
	public void resetText() {
		text.reset();
	}
	
	public String getText() {
		return text.toString().trim();
	}
	
	public ArrayList<RankValue> parseDocument(InputStream rin) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(this);
		
		InputStreamReader isReader = new InputStreamReader(rin, Charset.forName("utf-8"));
		reader.parse(new InputSource(isReader));
		
		return rankList;
	}
}
