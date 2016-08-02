package com.buynow.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 循环标签体内部的内容
 * @author Zhao
 *
 */
public class IteratorTag extends SimpleTagSupport {
	private int count;

	@Override
	public void doTag() throws JspException, IOException {
		
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
