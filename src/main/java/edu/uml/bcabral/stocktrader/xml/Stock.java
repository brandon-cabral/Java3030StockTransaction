package edu.uml.bcabral.stocktrader.xml;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlAccessorType;
import java.math.BigDecimal;


@XmlRootElement(name = "stock")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stock implements XMLDomainObject{

    @XmlAttribute(name = "symbol", required = true)
    protected String symbol;

    @XmlAttribute(name = "price", required = true)
    protected BigDecimal price;

    @XmlAttribute(name = "time", required = true)
    protected String time;

    public Stock(){}

    /**
     * Getter for symbol attribute
     * @return String
     */
    public String getSymbol(){
        return this.symbol;
    }


    /**
     * Setter for symbol attribute
     * @param symbol
     */
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }


    /**
     * Getter for price attribute
     * @return int
     */
    public BigDecimal getPrice(){
        return this.price;
    }


    /**
     * Setter for price attribute
     * @param price
     */
    public void setPrice(BigDecimal price){
        this.price = price;
    }


    /**
     * Getter for time attribute
     * @return String
     */
    public String getTime(){
        return this.time;
    }


    /**
     * Setter for time attribute
     * @param time
     *
     */
    public void setTime(String time)  {
        this.time = time;
    }

    public String toDatabase(){
        String data = "INSERT INTO quotes (symbol,time,price) VALUES ('"+symbol+"','"+time+"','"+price+"')";
        return data;

    }

    @Override
    public String toString(){
        String string = "StockTransaction(symbol: "+ this.symbol +" , price: "+ this.price +" , time: "+ this.time +" )";
        return string;
    }

}
