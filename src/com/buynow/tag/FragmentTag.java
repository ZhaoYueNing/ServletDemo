package com.buynow.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FragmentTag extends SimpleTagSupport{
	private JspFragment fragment;
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<h2>¶¯Ì¬ÏÔÊ¾Fragment</h2>");
		fragment.invoke(null);
	}

	public JspFragment getFragment() {
		return fragment;
	}

	public void setFragment(JspFragment fragment) {
		this.fragment = fragment;
	}
	
}
