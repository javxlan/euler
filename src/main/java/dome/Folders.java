package dome;

import java.util.Collection;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class Folders {
    public static void searchForLetter(NodeList nodeList, Collection<String> result, char startingLetter) {
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);
            Element e = (Element) tempNode;
            String folderName = e.getAttribute("name");
            if (folderName.charAt(0) == startingLetter)
                result.add(folderName);

            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                if (tempNode.hasChildNodes()) {
                    searchForLetter(tempNode.getChildNodes(), result, startingLetter);
                }
            }
        }
        return;
    }

    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = dBuilder.parse(is);
        doc.getDocumentElement().normalize();
        Collection<String> result = new LinkedList<String>();
        searchForLetter(doc.getChildNodes(), result, startingLetter);

        return result;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}
