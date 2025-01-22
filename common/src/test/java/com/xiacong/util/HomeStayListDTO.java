package com.xiacong.util;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class HomeStayListDTO {

    private Long beginDate;

    private Long endDate;

    private String district;

    private String name;
    private Integer maxPrice;

    private Integer minPrice;

    private String longitude;

    private String latitude;
}
