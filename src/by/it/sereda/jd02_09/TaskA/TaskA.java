package by.it.sereda.jd02_09.TaskA;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TaskA {

    final static String root = "src/by/it/sereda/jd02_09/TaskA/";

    public static void main(String[] args) {
        String fileName = root + "Airport.xml";
        String fileHTML = root + "Airport.html";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(root + "Airport.xsl"));
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e.getMessage());
        }
    }
}
