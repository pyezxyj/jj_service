package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IPositionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Position;
import com.cdkj.service.dto.req.XN612160Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 分页查询职位
 * @author: asus 
 * @since: 2017年6月7日 上午9:51:11 
 * @history:
 */
public class XN612160 extends AProcessor {
    private IPositionAO positionAO = SpringContextHolder
        .getBean(IPositionAO.class);

    private XN612160Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Position condition = new Position();
        condition.setName(req.getName());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setCompanyName(req.getCompanyName());
        condition.setKind(req.getKind());
        condition.setType(req.getType());
        condition.setLocation(req.getLocation());
        condition.setStatus(req.getStatus());
        condition.setPublisher(req.getPublisher());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IPositionAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return positionAO.queryPositionPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612160Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}
