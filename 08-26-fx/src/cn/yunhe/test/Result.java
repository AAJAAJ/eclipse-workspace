package cn.yunhe.test;

import java.util.Map;

/**
 * 数据结果封装类
 */
public class Result<R> {

	/**
	 * 返回状态码
	 * 200 代表成功
	 * 500 代表程序错误
	 */
	private int code;
	/**
	 * 返回结果字符串
	 */
	private String msg;
	/**
	 * 返回的数据
	 */
	private R data;
	
	/**
	 * 请求成功但不需要返回数据
	 */
	public Result() {
		this.code = 200;
		this.msg = "success";
	}
	
	/**
	 * 请求成功并需要返回数据使用
	 * @param data
	 */
	public Result(R data) {
		this.code = 200;
		this.msg = "success";
		this.data = data;
	}
	
	public Result(int code,String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public R getData() {
		return data;
	}

	public void setData(R data) {
		this.data = data;
	}

	/**
	 * 静态方法--用于设置数据并返回
	 * @param <T>
	 * @param data
	 * @return
	 */
	public static <T> Result<T> success(T data){
		return new Result<T>(data);
	}

}
