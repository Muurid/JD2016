package by.it.sereda.jd02_08;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class DOM {

    public static void main(String[] args) {
        String filename = "src/by/it/sereda/jd02_07/Airport.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(filename);
            Element element=document.getDocumentElement();
            printDom("","",element);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void printDom(String prefix, String name, Node node) {
        int type = node.getNodeType();
        switch (type) {

            case Node.DOCUMENT_NODE: {
                System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                printDom("","",((Document) node).getDocumentElement());
                break;
            }


            case Node.ELEMENT_NODE: {
                System.out.print("<");
                System.out.print(node.getNodeName());
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++)
                    printDom("","",attributes.item(i));
                System.out.print(">");
                if (node.hasChildNodes()) {
                    NodeList children = node.getChildNodes();
                    //prefix=prefix+"\t";
                    for (int i = 0; i < children.getLength(); i++)
                        printDom("","",children.item(i));
                }
                System.out.print("</");
                System.out.print(node.getNodeName());
                System.out.print(">");
                break;
            }

            case Node.ATTRIBUTE_NODE: {
                System.out.print(" " + node.getNodeName() + "=\"" +
                        ((Attr) node).getValue() + "\"");
                break;
            }

            case Node.TEXT_NODE: {
                System.out.print(node.getNodeValue());
                break;
            }
        }
    }
}