package com.jd.cms.test.webService.schemalConstrain.XMLandJAVA;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * @author zhaochengye
 * @date 2019-04-10 17:58
 */
public class XML2Java {

    @Test
    public void get() throws Exception{
        //获取工厂实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //获取解析器
        DocumentBuilder db = dbf.newDocumentBuilder();
        //解析成dom
        Document dom = db.parse("/Users/zhaochengye/Documents/gitProject/gitUserHand/cms/src/main/java/com/jd/cms/test/webService/schemalConstrain/xsd/bookStore.xml");
        //获取根元素对象
        Node node = dom.getFirstChild();
        //获取标签的名字
        System.out.println(node.getNodeName());
        //获取到每个标签对象，都是一个element的实例对象
        Element root = (Element)node;
        // 获取books下面的所有book标签
        NodeList nl = root.getElementsByTagName("book");
        for (int i = 0; i < nl.getLength(); i++) {
            // 获取到每个book标签对象
            Element book = (Element) nl.item(i);
            // NodeList book_child = book.getChildNodes();
            Element name = (Element) book.getElementsByTagName("name").item(0);
            Element author = (Element) book.getElementsByTagName("author")
                    .item(0);
            Element price = (Element) book.getElementsByTagName("price")
                    .item(0);
            // 获取name标签下的文本值
            System.out.println(name.getTextContent());
            // 获取标签上的属性值
            System.out.println(name.getAttribute("id"));
            // 获取author标签下的文本值
            System.out.println(author.getTextContent());

            // 获取price标签下的文本值
            System.out.println(price.getTextContent());

            System.out.println("-------------------");

        }

    }

    /*
     * 修改dom中标签的信息
     * 把books中的第二个book标签中的price的值改为100
     *
     */
    @Test
    public void update() throws Exception {
        // 获取工厂实例对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // 获取解析器对象
        DocumentBuilder db = dbf.newDocumentBuilder();
        // 解析xml获取dom对象
        Document dom = db.parse("/Users/zhaochengye/Documents/gitProject/gitUserHand/cms/src/main/java/com/jd/cms/test/webService/schemalConstrain/xsd/bookStore2.xml");
        //使用dom树直接根据标签名获取对应的标签对象
        Element book = (Element) dom.getElementsByTagName("book").item(0);
        //获取price标签
        Element price = (Element) book.getElementsByTagName("price").item(0);
        price.setTextContent("100");
        System.out.println(price.getTextContent());

        //把修改的整个dom树重新写到文件中
        TransformerFactory tff = TransformerFactory.newInstance();
        //获取转换器
        Transformer transformer = tff.newTransformer();
        //和文件关联出去结果对象
        StreamResult sr = new StreamResult("/Users/zhaochengye/Documents/gitProject/gitUserHand/cms/src/main/java/com/jd/cms/test/webService/schemalConstrain/xsd/bookStore2.xml");
        //把dom转成原始数据对象
        DOMSource ds = new DOMSource(dom);
        //保存数据
        transformer.transform(ds, sr);
    }
}
