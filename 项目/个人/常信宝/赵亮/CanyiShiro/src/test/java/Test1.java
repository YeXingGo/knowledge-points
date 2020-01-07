import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ssm.entiy.SysUser;
import com.ssm.mapper.SysUserMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-common.xml","classpath:spring-mvc.xml","classpath:spring-commonShiro.xml"})
public class Test1 {
	@Autowired
	private SysUserMapper userMapper;
	@Test
	public void ss(){
		List<SysUser> sysUserAll = userMapper.getSysUserAll();
		for (SysUser sysUser : sysUserAll) {
			System.out.println(sysUser);
		}
		System.out.println(1);
	}
}
