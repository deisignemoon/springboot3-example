package com.xiacong.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class IsShipLineCache {

    private Long id;

    /**
     * 航线号
     */
    private Integer lineNum;

    /**
     * 航线名
     */
    private String lineName;

    /**
     * 航次
     */
    private Integer lineNo;
    /**
     * 船名
     */
    private String shipName;

    /**
     * 所属公司编码
     */
    private String dwh;

    /**
     * 起始港号
     */
    private Integer startPortNo;

    /**
     * 起始港名
     */
    private String startPortName;

    /**
     * 停靠港号
     */
    private Integer endPortNo;

    /**
     * 停靠港名
     */
    private String endPortName;

    /**
     * 开船日期
     */
    private String sailDate;

    /**
     * 开船时间
     */
    private String sailTime;

    /**
     * 开车时间
     */
    private String busStartTime;

    /**
     * 时序
     */
    private Integer sx;

    /**
     * 航线方向，1：进嵊，2：出嵊
     */
    private Integer lineDirect;

    /**
     * 当天售票开始时间
     */
    private String saleBeginTime;

    /**
     * 当天售票结束时间
     */
    private String saleEndTime;

    /**
     * 开船前停售时间，单位：min
     */
    private Long stopSaleTime;

    /**
     * 是否可售，false：当前航班页面可以显示，但是不能购买
     */
    private Boolean onSale;

    /**
     * 不可售原因
     */
    private String offSaleMsg;

    /**
     * 购买船票类型，1：旅客 2:车
     */
    private Integer buyTicketType;

    /**
     * 船类型号
     */
    private Integer clxh;

    /**
     * 船类型名
     */
    private String clxm;

    /**
     * 航线类型号
     */
    private Integer hxlxh;

    /**
     * 航线类型名
     */
    private String hxlxm;

    /**
     * 是否前段开车，大于0表示前段开车
     */
    private Integer bus;

    /**
     * 是否后段开车，大于0表示后段开车
     */
    private Integer bus2;

    /**
     * 航线状态，对应tm1 w_hxzt
     */
    private Integer lineState;

    /**
     * 航线状态名，对应tm1 w_hxztm
     */
    private String lineStateName;

    /**
     * 上传港名，对应tm1 gmk2，bus&0的情况下显示
     */
    private String embarkPortName;

    /**
     * 免票儿童数
     */
    private Integer freeChildCount;

    /**
     * 截止候补时间，格式：hh:mm，开船前一天此时停止候补，可以开放购票
     */
    private String candidateTimeEnd;

    /**
     * 途经港口备注说明
     */
    private String portMemos;

    /**
     * 经过时间备注说明
     */
    private String timeMemos;

}