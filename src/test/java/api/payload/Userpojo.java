package api.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Userpojo {

	private int id;
	String username;
	String firstName;
	String lastName;
	String email;
	String password;
	String phone;
	int userStatus = 0;
	
	

}
