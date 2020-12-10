package hu.domparse.wsi08i;

import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOMReadWSI08I {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		//XML file objektum letrehozasa
		File xmlFile = new File("xmlWSI08I.xml");
		
		// Document Builder letrehozasa
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
				
		
		Document doc = dBuilder.parse(xmlFile);
		
		//normalizalas
		doc.getDocumentElement().normalize();
		
		//Gyoker elem kiiratasa
		Element root = doc.getDocumentElement();
		System.out.println("Gyoker elem: " + root.getNodeName());
		
		
		NodeList NL1 = doc.getElementsByTagName("kolcsonzo");
		
		for (int i = 0; i < NL1.getLength(); i++) {
			Node nNode = NL1.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			
				System.out.println();

				Element elem = (Element) nNode;
				
				System.out.println("Elem:" + nNode.getNodeName());
				String kol_id = elem.getAttribute("kol_id");

				Node n1 = elem.getElementsByTagName("nev").item(0);
				String nev = n1.getTextContent();

				Node n2 = elem.getElementsByTagName("email").item(0);
				String email = n2.getTextContent();

				Node n3 = elem.getElementsByTagName("lakcim").item(0);
				String lakcim = n3.getTextContent();

				System.out.println("id: " + kol_id);
				System.out.println("Neve: " + nev);
				System.out.println("email: " + email);
				System.out.println("lakcim: " + lakcim);
				
			}
		}
		
NodeList NL2 = doc.getElementsByTagName("kolcsonzes");
		
		for (int i = 0; i < NL2.getLength(); i++) {
			Node nNode = NL2.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			
				System.out.println();

				Element elem = (Element) nNode;
				
				System.out.println("Elem:" + nNode.getNodeName());
				String kod = elem.getAttribute("kod");
				String kol_id = elem.getAttribute("kol_id");

				Node n1 = elem.getElementsByTagName("hatarido").item(0);
				String hat = n1.getTextContent();

				

				System.out.print("kod: " + kod +", ");
				System.out.println("kolcsonzes id: " + kol_id);
				System.out.println("hatarido: " + hat);
				
				
			}
		}
		
		NodeList NL3 = doc.getElementsByTagName("iro");

		for (int i = 0; i < NL3.getLength(); i++) {
			Node nNode = NL3.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				System.out.println();

				System.out.println("Elem:" + nNode.getNodeName());
				String iid = elem.getAttribute("i_id");

				Node n1 = elem.getElementsByTagName("nev").item(0);
				String nev = n1.getTextContent();
				
				Node n2 = elem.getElementsByTagName("nemzetiseg").item(0);
				String nemz = n1.getTextContent();

				System.out.println("Iro id: " + iid);
				System.out.println("nev: " + nev);
				System.out.println("nemzetiseg: " + nemz);

			}
		}
		
		NodeList NL4 = doc.getElementsByTagName("konyvtar");

		for (int i = 0; i < NL4.getLength(); i++) {
			Node nNode = NL4.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				System.out.println();

				System.out.println("Elem:" + nNode.getNodeName());
				String ktazon = elem.getAttribute("kt_azon");

				Node n1 = elem.getElementsByTagName("nev").item(0);
				String nev = n1.getTextContent();
				
				Node n2 = elem.getElementsByTagName("varos").item(0);
				String varos = n1.getTextContent();

				System.out.println("Konyvtar azonosito: " + ktazon);
				System.out.println("nev: " + nev);
				System.out.println("varos: " + varos);

			}
		}
		
		NodeList NL5 = doc.getElementsByTagName("konyv");

		for (int i = 0; i < NL5.getLength(); i++) {
			Node nNode = NL5.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				System.out.println();

				System.out.println("Elem:" + nNode.getNodeName());
				String kkod = elem.getAttribute("konyv_kod");
				String ktazon = elem.getAttribute("kt_azon");

				Node n1 = elem.getElementsByTagName("cim").item(0);
				String cim = n1.getTextContent();
				
				Node n2 = elem.getElementsByTagName("mûfaj").item(0);
				String mufaj = n1.getTextContent();

				System.out.println("konyv kod: " + kkod);
				System.out.println("Konyvtar azonosito: " + ktazon);
				System.out.println("cim: " + cim);
				System.out.println("mufaj: " + mufaj);

			}
		}
		
		NodeList NL6 = doc.getElementsByTagName("kiadas");

		for (int i = 0; i < NL6.getLength(); i++) {
			Node nNode = NL6.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				System.out.println();

				System.out.println("Elem:" + nNode.getNodeName());
				String iid = elem.getAttribute("i_id");
				String kkod = elem.getAttribute("konyv_kod");

				Node n1 = elem.getElementsByTagName("kiadas_datum").item(0);
				String kdatum = n1.getTextContent();
				
				Node n2 = elem.getElementsByTagName("nyelv").item(0);
				String nyelv = n1.getTextContent();

				System.out.println("Iro id: " + iid);
				System.out.println("Konyv kod: " + kkod);
				System.out.println("kiadas datum: " + kdatum);
				System.out.println("nyelv: " + nyelv);

			}
		}
		
		NodeList NL7 = doc.getElementsByTagName("kolcskonyv");

		for (int i = 0; i < NL7.getLength(); i++) {
			Node nNode = NL7.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;
				System.out.println();

				System.out.println("Elem:" + nNode.getNodeName());
				String kod = elem.getAttribute("kod");
				String kkod = elem.getAttribute("konyv_kod");


				System.out.println("Kolcsonzes kodja:: " + kod);
				System.out.println("Konyv kod: " + kkod);

			}
		}
				
	}

}
