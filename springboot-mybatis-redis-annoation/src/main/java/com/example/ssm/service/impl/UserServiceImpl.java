package com.example.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ssm.dao.CommodityMapper;
import com.example.ssm.dao.UserMapper;
import com.example.ssm.domain.Commodity;
import com.example.ssm.domain.User;
import com.example.ssm.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CommodityMapper commodityMapper;

	/**
	 * 
	 * @CachePut也可以声明一个方法支持缓存功能。
	 * 与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
	 * 而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
	 *
	 */
	@CachePut("users")
	// 每次都会执行方法，并将结果存入指定的缓存中
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userMapper.getAllUserList();
	}

	@Transactional
	@Override

	public void insert(User user) {
		userMapper.insert(user);
	}

	@Transactional
	@Override
	public void test() {
		User user = new User();
		user.setUserId("3");
		user.setUserName("王五");
		user.setUserLoginName("wangwu");
		user.setUserPassword("123456");
		user.setUserEmail("wangwu@qq.com");
		user.setUserPhone("15712345678");

		Commodity comm = new Commodity();
		comm.setCommodityId("5");
		comm.setCommodityName("测试手机");
		comm.setCommodityType("phone");
		comm.setCommodityPrice(1000);

		userMapper.insert(user);
		System.out.println("//////////////////////////////////////////");
		System.out.println(1 / 0);
		commodityMapper.insert(comm);

	}

	// 因为配置文件继承了CachingConfigurerSupport，所以没有指定key的话就是用默认KEY生成策略生成,我们这里指定了KEY
	// @Cacheable(value = "userInfo", key = "'getById' + #userId", condition =
	// "#id%2==0")
	@Cacheable(value = "userInfo", key = "'getById' + #userId")
	// value属性指定Cache名称
	// 使用key属性自定义key
	// condition属性指定发生的条件(如上示例表示只有当user的id为偶数时才会进行缓存)
	@Override
	public User getById(String userId) {
		System.out.println("===没有经过缓存===");
		return userMapper.selectByPrimaryKey(userId);
	}

	@Transactional
	@Override
	// @CacheEvict(value="propertyInfo",allEntries=true) 清空全部
	// 删除指定缓存
	@CacheEvict(value = "userInfo", key = "'getById' + #userId")
	// 其他属性
	// allEntries是boolean类型，表示是否需要清除缓存中的所有元素。默认为false，表示不需要。当指定了allEntries为true时，Spring
	// Cache将忽略指定的key。
	// 清除操作默认是在对应方法成功执行之后触发的，即方法如果因为抛出异常而未能成功返回时也不会触发清除操作。
	// 使用beforeInvocation可以改变触发清除操作的时间，当我们指定该属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素。
	public void delete(String userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

}
