package models;

import java.util.List;
import lombok.Data;

@Data
public class GetUserResponse{
	private List<GetUserResponseItem> getUserResponse;
}