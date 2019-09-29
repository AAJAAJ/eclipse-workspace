/**
 * 
 */
package cn.yunhe.server;
import cn.yunhe.entity.User;

/**
 * @author 魏无羡 
 *2019年9月10日
 */
public interface UserServer {
	User user(String userName,String password);
}
