package cn.yunhe.entity;

import java.util.Date;

public class Order {

	private String order_id;
	
	private Date create_time;
	
	private String send_phone;
	
	private User user;
	
	public Order() {}

	public Order(String order_id, Date create_time, String send_phone, User user) {
		super();
		this.order_id = order_id;
		this.create_time = create_time;
		this.send_phone = send_phone;
		this.user = user;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getSend_phone() {
		return send_phone;
	}

	public void setSend_phone(String send_phone) {
		this.send_phone = send_phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", create_time=" + create_time + ", send_phone=" + send_phone + ", user="
				+ user + "]";
	}
	
}
