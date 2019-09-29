package test;

import test.outer.inner;

/** 

* @author 性感渣渣傲在线打bug

* @version 创建时间：2019年8月19日 下午1:57:55 

*/
public class day0819 {
public static void main(String[] args) {
	outer outer = new outer();
	inner inner = outer.new inner();
	inner.innerFun();
	outer.outerfun();

}
}
