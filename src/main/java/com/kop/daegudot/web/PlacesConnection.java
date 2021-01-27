package com.kop.daegudot.web;

import com.kop.daegudot.web.dto.PlacesDto;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;


@RestController
public class PlacesConnection {

    /* Get data based on XML from url*/
    public ArrayList<PlacesDto> opendatasHttp() {
        ArrayList<PlacesDto> mArrayList = new ArrayList<>();

        try {
            String url = "http://pacific-forest-24713.herokuapp.com/getTourData?pageNo=1&numOfRows=271";

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(url);

            document.getDocumentElement().normalize();

            //Get data by tag name
            NodeList nodeList = document.getElementsByTagName("list");

            /* Get data by tag value
            Add to arraylist based on opendata dto*/
            for(int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    mArrayList.add(new PlacesDto(getTagValue("address",element),
                            getTagValue("attractcontents",element),
                            getTagValue("attractname",element),
                            getTagValue("homepage",element),
                            getTagValue("tel",element)));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return mArrayList;
    }

    //XML parsing
    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        if(node == null) return null;

        return node.getNodeValue();
    }
}
