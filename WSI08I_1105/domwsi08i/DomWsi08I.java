package domwsi08i;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;



public class DomWsi08I {
	
	

	public static void main(String[] args) {
		
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("src/domwsi08i/szemelyek.xml"));
			doc.getDocumentElement().normalize();
			
			Element root = doc.getDocumentElement();
			
			System.out.println("root: " + root.getNodeName());

			NodeList childnods = root.getChildNodes();
			for (int i = 0; i < childnods.getLength(); i++) {
				
				Node n = childnods.item(i);
				if (n.getNodeType() == n.ELEMENT_NODE) {
					
					Element el = (Element) n;
					String id = el.getAttribute("id");
					
					System.out.println("Id: " + id);

					Node currentnode = el.getFirstChild();
					while (currentnode != null) {
						
						if (currentnode.getNodeType() == n.ELEMENT_NODE) {
							Element currelement = (Element) currentnode;
							System.out.println(" " + currelement.getNodeName() + ": " + currelement.getTextContent());
						}
						currentnode = currentnode.getNextSibling();
					}
					System.out.println();
				}
			}
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
