package restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Greeting {
	private Long id;
	private String content;
	
	public Greeting() {
		
	}
	public Greeting(Long id, String content) {
		this.id= id;
		this.content= content;
	}
	public Long getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	
	@Override
	public String toString() {
		return "Id = "+ id + "," + content;
	}

}
