package com.uml.cabral.xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "stocks")
public class Stocks implements XMLDomainObject{

    @XmlElement(required = true)
    protected Stock stock;

    public Stocks() {}


    public Stock getStock(){
        return stock;
    }

    public void setStock(Stock value){
        this.stock = value;
    }

    @Override
    public String toString(){
        return "Stocks {" +
                "stock="  + stock +
                "}";
    }

}
