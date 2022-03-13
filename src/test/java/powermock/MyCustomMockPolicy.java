package powermock;

import java.lang.reflect.Method;

import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.mockpolicies.MockPolicyClassLoadingSettings;
import org.powermock.mockpolicies.MockPolicyInterceptionSettings;
import org.powermock.reflect.Whitebox;

public class MyCustomMockPolicy implements PowerMockPolicy {

    /**
	 * Add the {@link Dependency} to the list of classes that should be loaded
	 * by the mock class-loader.
	 */
	public void applyClassLoadingPolicy(MockPolicyClassLoadingSettings settings) {
		settings.addFullyQualifiedNamesOfClassesToLoadByMockClassloader(Dependency.class.getName());
	}

	/**
	 * Every time the {@link Dependency#getData()} method is invoked we return a
	 * custom instance of a {@link DataObject}.
	 */
	public void applyInterceptionPolicy(MockPolicyInterceptionSettings settings) {
		final Method getDataMethod = Whitebox.getMethod(Dependency.class, "getData");
		final DataObject dataObject = new DataObject("Policy generated data object");
		settings.stubMethod(getDataMethod, dataObject);
	}

}
