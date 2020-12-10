package hu.domparse.wsi08i;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class DOMModifyWSI08I {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		// XML file meghatarozasa
				File xmlFile = new File("xmlWSI08I.xml");

				// Document Builder letrehozasa
		        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder builder = factory.newDocumentBuilder();

		        // DOM objektumma konvertalas
		        Document doc = builder.parse(xmlFile);
		        
		        // normalizalas
		        doc.getDocumentElement().normalize();

		        // xPath segítségével módosítandó elem meghatározása
		        XPath xPath = XPathFactory.newInstance().newXPath();

		        // modositando elem
		        String expr1 = "/root/kolcsonzo[@kol_id = '01']/nev/text()";
		        NodeList nodeList1 = (NodeList) xPath.compile(expr1).evaluate(doc, XPathConstants.NODESET);

		        // Mire szeretnénk átírni
		        nodeList1.item(0).setNodeValue("Radocz Nikolett");

		        // Elérés megadása
		        String expr2 = "/root/kolcsonzo[@kol_id = '01']";
		        nodeList1 = (NodeList) xPath.compile(expr2).evaluate(doc, XPathConstants.NODESET);
		        
		        String expr3 = "/root/iro[@i_id = '02']/nev/text()";
		        NodeList nodeList2 = (NodeList) xPath.compile(expr3).evaluate(doc, XPathConstants.NODESET);
		        
		        nodeList2.item(0).setNodeValue("temp");
		        
		        String expr4 = "/root/iro[@i_id = '02']";
		        nodeList2 = (NodeList) xPath.compile(expr4).evaluate(doc, XPathConstants.NODESET);

		        for (int i = 0; i < nodeList1.getLength(); i++) {
		            Node nNode = nodeList1.item(i);

		            System.out.println("\nCurrent Element : " + nNode.getNodeName());

		        // Ciklussal kiirattatjuk az értékeket
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element eElement = (Element) nNode;

		                System.out.println("Kolcsonzo id: " + eElement.getAttribute("kol_id"));

		                System.out.println("Nev: " + eElement.getElementsByTagName("nev").item(0).getTextContent());

		                System.out.println("E-mail: " + eElement.getElementsByTagName("email").item(0).getTextContent());

		                System.out.println("Lakcim: " + eElement.getElementsByTagName("lakcim").item(0).getTextContent());
		            }
		        }
		        
		        for (int i = 0; i < nodeList2.getLength(); i++) {
		            Node nNode = nodeList2.item(i);

		            System.out.println("\nCurrent Element : " + nNode.getNodeName());

		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                Element eElement = (Element) nNode;

		                System.out.println("Iro id: " + eElement.getAttribute("i_id"));
		                
		                System.out.println("Iro neve: " + eElement.getElementsByTagName("nev").item(0).getTextContent());

		                System.out.println("Iro nemzetisege: " + eElement.getElementsByTagName("nemzetiseg").item(0).getTextContent());
		            }
		        }

	}

}
