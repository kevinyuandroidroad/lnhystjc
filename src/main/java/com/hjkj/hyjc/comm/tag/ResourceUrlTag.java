package com.hjkj.hyjc.comm.tag;

import javax.servlet.jsp.tagext.TagSupport;

public class ResourceUrlTag extends TagSupport {

    private static final long serialVersionUID = 1L;

    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }

}
