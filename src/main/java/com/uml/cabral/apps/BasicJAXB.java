package com.uml.cabral.apps;


import com.uml.cabral.util.DatabaseConnectionException;
import com.uml.cabral.util.DatabaseException;
import com.uml.cabral.util.DatabaseUtils;
import com.uml.cabral.xml.Stock;
import com.uml.cabral.xml.Stocks;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import javax.xml.bind.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasicJAXB {


    private static String xmlInstance = "<stocks>\n" +
                    "    <stock symbol=\"VNET\" price=\"110.10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"AGTK\" price=\"120.10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"AKAM\" price=\"3.10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"AOL\"  price=\"30.10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"BCOM\" price=\"10.10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"BIDU\" price=\"10.10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"BCOR\" price=\"12.10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"WIFI\" price=\"16.10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"BRNW\" price=\"0.70\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"CARB\" price=\"9.80\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"JRJC\" price=\"111.11\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"CCIH\" price=\"22.20\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"CHIC\" price=\"4.30\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"CNV\"  price=\"13.43\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"CCOI\" price=\"1.10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"CNCG\" price=\".10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"CXDO\" price=\"90.00\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"CRWG\" price=\"52.99\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"ELNK\" price=\"45.40\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"EATR\" price=\"15.60\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"EDXC\" price=\"18.40\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"ENV\"  price=\"220.61\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"EPAZ\" price=\"101.11\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"FB\"   price=\"500.17\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"FDIT\" price=\"160.90\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"FLPC\" price=\"177.70\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"GCLT\" price=\"8.90\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"GOOG\" price=\"700.10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"GOOG\" price=\".10\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"GREZ\" price=\"77.91\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"IACI\" price=\"40.52\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"ICOA\" price=\"48.30\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"IIJI\" price=\"32.80\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"ILIA\" price=\"188.22\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"INAP\" price=\"2.12\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"IPAS\" price=\"1.02\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"JCOM\" price=\"19.99\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"LOGL\" price=\"18.21\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"LLNW\" price=\"45.55\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"LOOK\" price=\"38.90\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"MEET\" price=\"21.27\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"MEET\" price=\"310.31\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"VOIS\" price=\"440.51\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"MOMO\" price=\"8.51\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"NETE\" price=\"13.16\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"NTES\" price=\"14.23\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"EGOV\" price=\"17.35\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"NQ\" price=\"110.77\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "    <stock symbol=\"OTOW\" price=\"60.41\" time=\"2015-02-10 00:00:01\"/>\n" +
                    "</stocks>";


    public static void main(String[] args)throws JAXBException, ParserConfigurationException, IOException, SAXException, DatabaseConnectionException, DatabaseException {

        /**
         * Unmarshall the Stocks Pojo. Uses xmlInstance above.
         */
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new StringReader(xmlInstance));
        System.out.println(stocks);

        /**
         * Build a parseable document that I can iterate throguh based on elements.
         */
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(xmlInstance));
        Document doc = builder.parse(src);
        doc.getDocumentElement().normalize();
        System.out.println("stocks: \n");
        List<String> queryList = new ArrayList<>();

        NodeList nodeList = doc.getElementsByTagName("stock");
        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            Element element = (Element) node;

            /**
             * find attributes for each stock quote, then assign it to variable and assign to a stock pojo.
             */
            String symbol = element.getAttribute("symbol");
            BigDecimal price = new BigDecimal(element.getAttribute("price"));
            String time = element.getAttribute("time");
            Stock stock = new Stock();
            stock.setTime(time);
            stock.setPrice(price);
            stock.setSymbol(symbol);
            String queryString = stock.toDatabase();    // call the toDatabase method that creates an sql query for the stockquote
            System.out.println(queryString);            // test to see if I can see the converted quotes
            DatabaseUtils.executeSQL(queryString);      //send the query to mysql db
        }
    }
}
