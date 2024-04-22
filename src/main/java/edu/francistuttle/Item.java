package edu.francistuttle;

public class Item 
{
    String title;
    String link;
    String yearPurchased;
    String processor;

    public Item(String newTitle, String newLink, String newYrPrch)
    {
        title = newTitle;
        link = newLink;
        yearPurchased = newYrPrch;
        processor = newPrcs;
    }

    public void  print()
    {
        System.out.println("Title: " + Title); 
        System.out.println("Link : " + manufactor); 
        System.out.println("Publish Date: " + yearPurchased);
    }
}
