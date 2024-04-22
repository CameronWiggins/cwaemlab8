package edu.francistuttle;

import java.util.ArrayList;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws Exception {
      /* 
        Document document = readXMLDocumentFromFile("C:\\Users\\cw1101046\\Desktop\\Github\\cwparse\\src\\main\\java\\edu\\francistuttle\\lab.xml");
    
        //Verify XML Content
    
        //Here comes the root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
    
        //Get all employees
        NodeList nList = document.getElementsByTagName("computer");
        System.out.println("============================");
    
        for (int temp = 0; temp < nList.getLength(); temp++) {
          Node node = nList.item(temp);
        
          if (node.getNodeType() == Node.ELEMENT_NODE) {
            //Print each employee's detail
            Element eElement = (Element) node;
            System.out.println("\nComputer id : " + eElement.getAttribute("id"));
            System.out.println("Manufactor : " + eElement.getElementsByTagName("manufactor").item(0).getTextContent());
            System.out.println("Year Purchased : " + eElement.getElementsByTagName("yearPurchased").item(0).getTextContent());
            System.out.println("Processor : " + eElement.getElementsByTagName("processor").item(0).getTextContent());

            NodeList nList2 = eElement.getElementsByTagName("monitor");

           for (int i = 0; i < nList2.getLength(); i++) {
           Node childNode = nList2.item(i);
            
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                //Print each employee's detail
                Element eElement2 = (Element) childNode;
                System.out.println("\n\tMonitor id : " + eElement2.getAttribute("id"));
                System.out.println("\tManufactor : " + eElement2.getElementsByTagName("manufactor").item(0).getTextContent());
                System.out.println("\tResolution : " + eElement2.getElementsByTagName("resolution").item(0).getTextContent());
            }
            }
          }
        }
      */
 
      Channel cs = new Channel();

      ArrayList<Item> lab1 = cs.parse("C:\\Users\\cw1101046\\Desktop\\Github\\cwparse\\src\\main\\java\\edu\\francistuttle\\lab.xml");

      for (Item c : lab1)
      {
        c.print();
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
