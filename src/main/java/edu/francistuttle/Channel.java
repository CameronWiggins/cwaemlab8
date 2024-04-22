package edu.francistuttle;
import java.util.ArrayList;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Channel 
{
    public ArrayList<Item> parse(String pathname)
    {
        ArrayList<Item> computers = new ArrayList<Item>();
        try {
            Document document = readXMLDocumentFromFile(pathname);
            NodeList nList = document.getElementsByTagName("computer");
            for (int i = 0; i < nList.getLength(); i++)
            {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {

                    Element eElement = (Element) node;
                    computers.add(new Item(eElement.getAttribute("id"), eElement.getElementsByTagName("manufactor").item(0).getTextContent(), eElement.getElementsByTagName("yearPurchased").item(0).getTextContent(), eElement.getElementsByTagName("processor").item(0).getTextContent()));
                }
            }
            return computers;
            } 
        
        catch (Exception e) {
            System.out.println("Invalid" + e);
            return null;
        }
        
    }



public static Document readXMLDocumentFromFile(String fileNameWithPath) throws Exception {

        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
    
        //Build Document
        Document document = builder.parse(new File(fileNameWithPath));
    
        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();
    
        return document;
    }

}





