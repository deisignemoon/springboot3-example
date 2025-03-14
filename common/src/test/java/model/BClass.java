package model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class BClass implements Serializable {

    public BClass(String name, Integer age, BigDecimal salary, List<Books> books) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.books = books;
    }

    private String name;
    private Integer age;

    private BigDecimal salary;

    private List<Books> books;
}
