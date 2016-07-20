package by.it.sereda.jd02_09.taskc;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class ValidXSD {
    public static void main(String[ ] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName =   "src/by/it/sereda/jd02_09/taskc/Airport_XSD.xml";
        String schemaName = "src/by/it/sereda/jd02_09/taskc/Airport.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println("Файл " + fileName + " валиден.");
        } catch (SAXException e) {
            System.err.print("Валидация файла "+ fileName + " не выполена: "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print("Файл" + fileName + " не валиден:"
                    + e.getMessage());
        }
    }
}