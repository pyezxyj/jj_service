package com.cdkj.service.dto.req;

/**
 * 服务热门设置
 * @author: asus 
 * @since: 2017年6月6日 下午1:59:26 
 * @history:
 */
public class XN612084Req {

    // 服务编号 (必填)
    private String code;

    // UI位置（0普通 1热门）
    private String location;

    // 序号 (选填)
    private String orderNo;

    // 处理人 (必填)
    private String dealer;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
