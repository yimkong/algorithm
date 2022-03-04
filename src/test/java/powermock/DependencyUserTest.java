package powermock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.MockPolicy;
import org.powermock.modules.junit4.PowerMockRunner;
/**
 * 自定义policy可以统一对不需要的常用的对象以及对象的方法进行统一mock，例如slf4j
 * https://github.com/powermock/powermock/wiki/Mock-Policies
 */
@RunWith(PowerMockRunner.class)
@MockPolicy(MyCustomMockPolicy.class)
public class DependencyUserTest {
	@Test
	public void assertThatMyFirstMockPolicyWork() throws Exception {
		DataObject dependencyData = new DependencyUser().getDependencyData();
		Assert.assertEquals("Policy generated data object", dependencyData.getData());
	}
}
