package powermock;

public class Dependency {
    private final DataObject dataObject;

	public Dependency(String data) {
		dataObject = new DataObject(data);
	}

	public DataObject getData() {
		return dataObject;
	}
}
