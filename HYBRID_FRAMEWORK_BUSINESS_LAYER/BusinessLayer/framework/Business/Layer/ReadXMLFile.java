/**
 * 
 */
package framework.Business.Layer;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * @author cdeyso
 *
 */
public class ReadXMLFile {
	
	/** The location of XML Config File */
	public static String xmlConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/Configuration/XMLconfig.propertiess";
	
	/** The variable to store the location of the XML File to be read */
	public static String XML_filePath = null;
	
	/**
	 * Method to Read an XML File statically i.e hardcoding the values to be read from the File.
	 * 
	 */
	public static void readXMLFileStatic() {
		
		  try {

			  	XML_filePath = ReadPropertyFile.getInstance(xmlConfigFile).getProperty("xml_FILENAME");
				File fXmlFile = new File(XML_filePath);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);

				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();

				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

				NodeList nList = doc.getElementsByTagName("item_fully_qualified_reference");

				System.out.println("----------------------------");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);

					System.out.println("\nCurrent Element :" + nNode.getNodeName());

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;

						System.out.println("Staff id : " + eElement.getAttribute("id"));
						System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
						System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
						System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
						System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

					}
				}
			    } catch (Exception e) {
				e.printStackTrace();
			    }
		
	}
	
	/**
	 * TODO -- to create a method that gets all the elements inside a node in an XML File (Dynamic)
	 */
	

	/**
	 * TODO -- to create a method that gets all the attributes inside an element in a node in an XML File (Dynamic)
	 */
}
