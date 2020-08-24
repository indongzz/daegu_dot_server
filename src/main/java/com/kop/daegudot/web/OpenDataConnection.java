package com.kop.daegudot.web;

import com.kop.daegudot.web.dto.OpendataDto;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;


@RestController
public class OpenDataConnection {

    public ArrayList<OpendataDto> opendatasHttp(){
        ArrayList<OpendataDto> mArrayList = new ArrayList<>();

        try {
            String url = "http://pacific-forest-24713.herokuapp.com/getTourData?pageNo=1&numOfRows=271";

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(url);

            document.getDocumentElement().normalize();
            System.out.println("Root element : " + document.getDocumentElement().getNodeName());

            NodeList nodeList = document.getElementsByTagName("list");
            System.out.println("파싱 개수 : " + nodeList.getLength());

            for(int i=0; i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    mArrayList.add(new OpendataDto(getTagValue("address",element),
                            getTagValue("attractcontents",element),
                            getTagValue("attractname",element),
                            getTagValue("homepage",element),
                            getTagValue("tel",element)));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return mArrayList;
    }

    //XML parsing
    private String getTagValue(String tag, Element element){
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        if(node == null) return null;
        return node.getNodeValue();
    }
}
