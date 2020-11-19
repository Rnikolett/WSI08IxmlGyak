package domwsi08i;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParserWSI08I {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			Document doc = db.parse("src/domwsi08i/student.xml");
			
			System.out.println("root: "+doc.getDocumentElement().getNodeName());
			
			NodeList nl = doc.getElementsByTagName("student");
			System.out.println("---------------------------");
			
			for (int i = 0; i < nl.getLength(); i++) {
				Node n=nl.item(i);
				System.out.println("\nCurrent Element: " +n.getNodeName());
				if(n.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element)n;
					System.out.println("roll no: "+e.getAttribute("rollno"));
					
					Node currentnode = e.getFirstChild();
					while (currentnode != null) {
						
						if (currentnode.getNodeType() == n.ELEMENT_NODE) {
							Element currelement = (Element) currentnode;
							System.out.println(" " + currelement.getNodeName() + ": " + currelement.getTextContent());
						}
						currentnode = currentnode.getNextSibling();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
