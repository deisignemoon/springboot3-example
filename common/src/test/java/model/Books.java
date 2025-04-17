package model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Books implements Serializable {
    public Books(Integer id, String bookName, String author, BigDecimal price) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    private Integer id;

    private String bookName;

    private String author;

    private BigDecimal price;
}
