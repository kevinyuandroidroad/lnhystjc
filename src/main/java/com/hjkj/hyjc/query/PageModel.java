package com.hjkj.hyjc.query;

import java.util.List;
import java.util.Map;
/***
 * 分页查询用
 * @author Min
 *
 */
public class PageModel {
    //开始数
    private Integer start;
    //每页
    private Integer length;
    private Integer draw;
    private List<Map<String, String>> order;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public List<Map<String, String>> getOrder() {
        return order;
    }

    public void setOrder(List<Map<String, String>> order) {
        this.order = order;
    }

    public Integer getOrderColumn() {
        if (this.order!= null && this.order.size() > 0) {
            return Integer.parseInt(this.order.get(0).get("column"));
        }
        return null;
    }

    public String getOrderDir() {
        if (this.order.size() > 0) {
            return this.order.get(0).get("dir");
        }
        return null;
    }
}
