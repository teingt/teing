package User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue

	private long id;
	
	@NotNull
	@Size(min=4, max=255)
	private String username;
	
	@NotNull
	@Size(min=4, max=255)
	private String displayName;
	
	@NotNull
	@Size(min=8, max=255)
	@Pattern(regexp = "^(?=."[a-z])(?=.*[A-Z])(?=.*\\d)."$")
	private String password;
	
}
