package edu.francistuttle;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) throws Exception {

    parseRssFeed("https://rss.nytimes.com/services/xml/rss/nyt/World.xml",3);

    // Document document = readXMLDocumentFromFile("C:\\Users\\cw1101046\\Desktop\\Github\\cwaemlab8\\src\\main\\java\\edu\\francistuttle\\nasa.xml");

    // //Here comes the root node
    // Element root = document.getDocumentElement();
    // System.out.println(root.getNodeName());

    // // Get all employees
    // NodeList nList = document.getElementsByTagName("item");
    // System.out.println("============================");

    // for (int temp = 0; temp < nList.getLength(); temp++) {
    //   Node node = nList.item(temp);

    //   if (node.getNodeType() == Node.ELEMENT_NODE) {
    //     // Print each employee's detail
    //     Element eElement = (Element) node;
    //     System.out.println("\nTitle : " + eElement.getElementsByTagName("title").item(0).getTextContent());
    //     System.out.println("Link : " + eElement.getElementsByTagName("link").item(0).getTextContent());
    //     System.out.println("Publish Date : " + eElement.getElementsByTagName("pubDate").item(0).getTextContent());

    //   }
    // }
  }

  public static Document readXMLDocumentFromFile(String fileNameWithPath) throws Exception {

    // Get Document Builder
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    // Build Document
    Document document = builder.parse(new File(fileNameWithPath));

    // Normalize the XML Structure; It's just too important !!
    document.getDocumentElement().normalize();

    return document;
  }

  public static ArrayList<RSSItem> parseRssFeed(String url, int maxItems) {
    ArrayList<RSSItem> rssList = new ArrayList<RSSItem>();
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();

      CloseableHttpClient client = HttpClients.createDefault();
      HttpGet httpGet = new HttpGet(url);

      try (CloseableHttpResponse response1 = client.execute(httpGet)) {
        final HttpEntity entity = response1.getEntity();
        if (entity != null) {

          try (InputStream inputStream = entity.getContent()) {
            Document document = builder.parse(inputStream);
            Element root = document.getDocumentElement();
            System.out.println(root.getNodeName());

            // Get all employees
            NodeList nList = document.getElementsByTagName("item");
            System.out.println("============================");

            for (int temp = 0; temp < maxItems; temp++) {
              Node node = nList.item(temp);

              if (node.getNodeType() == Node.ELEMENT_NODE) {
                // Print each employee's detail
                Element eElement = (Element) node;
                System.out.println("\nTitle : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Link : " + eElement.getElementsByTagName("link").item(0).getTextContent());
                System.out.println("Publish Date : " + eElement.getElementsByTagName("pubDate").item(0).getTextContent());
                String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                String link = eElement.getElementsByTagName("link").item(0).getTextContent();
                String pubDate = eElement.getElementsByTagName("pubDate").item(0).getTextContent();
                RSSItem item = new RSSItem(title, link, "", "", pubDate);
                rssList.add(item);
              }
            }
            return rssList;
          }
        }
      } catch (Exception e) {
        System.out.println("Hosed: " + e.toString());
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.toString());
    }
    return rssList;
  }
}
