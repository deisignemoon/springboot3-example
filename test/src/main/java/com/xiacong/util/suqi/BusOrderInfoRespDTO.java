package com.xiacong.util.suqi;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 *
 * @author xiacong
 * @Classname BusAddOrderReqDTO
 * @Version 1.0.0
 * @Date 2025/6/4 9:03
 * @Created by xiacong
 */
@Data
public class BusOrderInfoRespDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 外部订单号
     */
    private String outOrderNo;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系电话
     */
    private String contactTel;

    /**
     * 产品 ID
     */
    private String productId;

    /**
     * 线路 ID
     */
    private String lineId;

    /**
     * 出行日期 yyyy-MM-dd
     */
    private String travelDate;

    /**
     * 去程时间
     */
    private String goTime;

    /**
     * 套餐 ID
     */
    private String packId;

    /**
     * 上车站点 ID
     */
    private String stationUpId;

    /**
     * 下车站点 ID
     */
    private String stationDownId;

    /**
     * 订单价格
     */
    private String orderPrice;

    /**
     * 订单备注
     */
    private String orderRemark;

    /**
     * 航班号
     */
    private String flightNumber;

    /**
     * 出行人数
     */
    private String personNumber;

    /**
     * 票务类型 1.去程;2.往返； 3.返程
     */
    private String ticketType;

    /**
     * 司机电话
     */
    private String driverPhone;

    /**
     * 车牌号码
     */
    private String busNumber;

    /**
     * 订单状态 -1:取消 0:待支付1:待出行 2:出行中3:已完成 4:退款中5:已退款 6:确认中7:出票中
     */
    private String orderStatus;

    /**
     * 开票状态
     */
    private String invoiceStatus;

    /**
     * 出行人列表
     */
    private List<TravelPerson> travelPersons;
}
