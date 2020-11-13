package gsu;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Runner {
    public static void main(String[] argv) throws IOException, ParserConfigurationException, org.xml.sax.SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse("https://www.w3schools.com/xml/cd_catalog.xml");

        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList cdList = doc.getElementsByTagName("CD");

        CD[] cdObjects = new CD[cdList.getLength()];

        for (int i = 0; i < cdList.getLength(); i++) {

            Node nNode = cdList.item(i);

            System.out.println("\nCurrent Element: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                Node nodeTitle = elem.getElementsByTagName("TITLE").item(0);
                String title = nodeTitle.getTextContent();

                Node nodeArtist = elem.getElementsByTagName("ARTIST").item(0);
                String artist = nodeArtist.getTextContent();

                Node nodeCountry = elem.getElementsByTagName("COUNTRY").item(0);
                String country = nodeCountry.getTextContent();

                Node nodeCompany = elem.getElementsByTagName("COMPANY").item(0);
                String company = nodeCompany.getTextContent();

                Node nodePrice = elem.getElementsByTagName("PRICE").item(0);
                float price = Float.parseFloat(nodePrice.getTextContent());

                Node nodeYear = elem.getElementsByTagName("YEAR").item(0);
                int year = Integer.parseInt(nodeYear.getTextContent());

                cdObjects[i] = new CD(title, artist, country, company, price, year);

                System.out.println(cdObjects[i]);
            }

        }
    }
}