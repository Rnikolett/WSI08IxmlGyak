package pack;
import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import javax.xml.parsers.SAXParser;

import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.Locator;

//SAXHandle-t használta

public class SaxWSI08I implements ContentHandler{
	private Locator loc;
	int jel;
	public SaxWSI08I() {}
	
	public static void main(String[] args) {
		try {
			XMLReader parser = new SAXParser();
			SaxWSI08I Shand = new SaxWSI08I();
			parser.setContentHandler(Shand);
			if(args.length >0) {
				parser.parse(args[0]);
			}else(
				parser.parse("C:\\Users\\Radócz Nikoletta\\WSI08I_xml\\RN_WSI08I\\RN_1020\cats.xml");	
		}catch (SAXException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		} 
	

	public void startDocument() throws SAXException{
		System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" );
		System.out.println("cats start");
	}
	

	@Override
	public void setDocumentLocator(org.xml.sax.Locator locator) {
		this.loc=locator;
		
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("cats start");
		
	}
	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		
	}
	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		
	}
	@Override
	public void startElement(String uri, String localName, String rawName, Attributes atts) throws SAXException {
		if (jel==0) {
			if(localName.compareTo("cat")==0) {
				jel=1;
			}
		}else {
			jel++;
		}
		if(jel>=1) {
			System.out.println(rawName);
			for (int i = 0; i < atts.getLength(); i++) {
				System.out.println(" "+atts.getQName(i)+"="+atts.getValue(i));
			}
		}
	}
	@Override
	public void endElement(String uri, String localName, String rawName) throws SAXException {
		if(jel>=1) {
			System.out.println(rawName);
			if(localName.compareTo("cat")==0) {
				jel=0;
				System.out.println();
			}else jel--;
		}
		
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		//befejezni
		
	}
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		
	}
	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		
	}
	@Override
	public void skippedEntity(String name) throws SAXException {
		
	}
	
	}