package powermock;

public class DependencyUser {

    public DataObject getDependencyData() {
		return new Dependency("some data").getData();
	}
}
