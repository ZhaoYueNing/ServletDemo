package com.buynow.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextAttributeListener implements
		ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		//�������ʱ������
		System.out.println("##�������"+scab.getName()+" :"+scab.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		//���Ա�ɾ��
		System.out.println("##ɾ������"+scab.getName()+" :"+scab.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		//���Ա��滻
		System.out.println("##�滻����"+scab.getName()+" :"+scab.getValue());
	}

}
