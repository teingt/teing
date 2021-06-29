package User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {


	@Id
	@GeneratedValue
	private long id;
	
	@NotNull(message = "{hoaxify.constraint.username.NotNull.message}")
	@Size(min=4, max=20)
	@UniqueUsername
	private String username;
	
	@NotNull
	@Size(min=4, max=20)
	private String displayName;
	
	@NotNull
	@Size(min = 8, max = 20)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message="{hoaxify.constrain.password.Pattern.message}")
	private String password;

	public CharSequence getPassword() {
		return null;
	}

	public void setPassword(String encode) {
		
	}


}
