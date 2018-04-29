package gr.unisystems.ecm.microservises.core.review.model;

public class Review {
	private int productId;
	private int reviewId;
	private String author;
	private String subject;
	private String content;
	private int hostingServerPort;
	private String callID;

	public Review(int productId, int reviewId, String author, String subject, String content, int hostingServerPort, String callID) {
		this.productId = productId;
		this.reviewId = reviewId;
		this.author = author;
		this.subject = subject;
		this.content = content;
		this.hostingServerPort = hostingServerPort;
		this.callID = callID;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
