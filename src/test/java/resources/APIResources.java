package resources;

public enum APIResources {
	Add("/country/Add"),
	Fill("/country/Fill"),
	Update("/country/Update"),
	Delete("/country/Delete");

	private String resource;
	
	APIResources(String resource) {
		// TODO Auto-generated constructor stub
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}
}
