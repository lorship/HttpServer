package core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * @Description
 * @Date 23:43 2019/7/25
 **/
public class ServerXmlParser {
    private final static int DEFAULT_SERVER_PORT = 8080;

    public static int getPort(){
        int port = DEFAULT_SERVER_PORT;

        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read("conf/config.xml");
            Element element = (Element) document.selectSingleNode("//connector");
            port = Integer.parseInt(element.attributeValue("port"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return port;


    }
}
