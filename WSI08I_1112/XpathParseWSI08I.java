package hu.meiit.xpathparsewsi08i;
import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;


public class XpathParseWSI08I {
	/*private File f;
	public XpathParseWSI08I(File file) {
		this.f = file;
	}
	FileInputStream fis = new FileInputStream();*/
	
	//not finished yet
	public static void main(String[] args) {
	DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
	factory.setNamespaceAware(true);
	DocumentBuilder builder;
	Document doc = null;
	try {
		builder = factory.newDocumentBuilder();
		doc = builder.parse("studentWSI08I.xml");
		
		XPathFactory xpf = XPathFactory.newInstance();
		XPath xp = xpf.newXPath();
		//String name =ge
	} catch (Exception e) {
		e.printStackTrace();
	}

	}
	private static String getStudent(Document doc, XPath xp,int id) {
		String name=null;
		try {
			XPathExpression expr = xp.compile("/class/student");
			name = expr.evaluate(doc);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return name;
	}

}
