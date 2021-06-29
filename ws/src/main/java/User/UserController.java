package User;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import error.ApiError;
import shared.GenericResponse;

@RestController
@RequestMapping("/api/1.0")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public GenericResponse creatUser(@Valid @RequestBody User user) {
		userService.save(user);
		return new GenericResponse("user created") ;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleValidationException(MethodArgumentNotValidException exception) {
	   ApiError error = new ApiError(400,"Validation error", "/api/1.0/users");
	   Map<String, String> validationErrors = new HashMap<>();
	   for(FieldError fieldError: exception.getBindingResult().getFieldErrors()) {
		   validationErrors.put(getField(),fieldError.getDefaultMessage());

	   }   
	   error.setValidationErrors(validationErrors);
	   return error;
	}

	private String getField() {
		return null;
	}
}
