package com.xiacong.util;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TicketInfo {

    private Integer id;
    private Integer stock;
    private Integer used;
    private BigDecimal marketprice;
    private BigDecimal settlementprice;
    private BigDecimal sellingprice;
    private String date;
    private String ticketname;

}
