package com.xiacong.util;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Selltickets {

    private Integer id;
    private Integer t_id;
    private String ticketname;
    private Integer employee_id;
    private BigDecimal minprice;
    private List<TicketInfo> info;
}
