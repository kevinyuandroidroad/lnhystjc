package com.hjkj.hyjc.query;

import java.util.List;
import com.alibaba.fastjson.JSONObject;

public class ResponsePage {
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private List<?> data;

    public ResponsePage() {

    }

    public ResponsePage(Integer draw, Integer recordsTotal, Integer recordsFiltered, List<?> data) {
        this.draw = draw;
        this.recordsFiltered = recordsFiltered;
        this.recordsTotal = recordsTotal;
        this.data = data;
    }

    public long getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public String toJson() {
        return JSONObject.toJSONString(this);
    }
}
