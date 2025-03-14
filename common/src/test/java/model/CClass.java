package model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CClass implements Serializable {

    private String name;
    private Integer age;

    private BigDecimal salary;

    private List<Books> books;

    private BClass bClass;
}
