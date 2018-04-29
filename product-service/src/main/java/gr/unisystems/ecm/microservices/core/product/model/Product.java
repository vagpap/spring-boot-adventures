package gr.unisystems.ecm.microservices.core.product.model;

public class Product {
    private int productId;
    private String name;
    private int weight;
    private int hostingServerPort;
    private String callID;

    public Product(int productId, String name, int weight, int hostingServerPort, String callID) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.hostingServerPort = hostingServerPort;
        this.callID = callID;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

	public int getHostingServerPort() {
		return hostingServerPort;
	}

	public void setHostingServerPort(int hostingServerPort) {
		this.hostingServerPort = hostingServerPort;
	}

	public String getCallID() {
		return callID;
	}

	public void setCallID(String callID) {
		this.callID = callID;
	}
	
	
}
