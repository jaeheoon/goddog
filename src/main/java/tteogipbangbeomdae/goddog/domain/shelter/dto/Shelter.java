package tteogipbangbeomdae.goddog.domain.shelter.dto;
/**
 * @author  떡잎방범대 최은비
 * @since   2023. 9. 11.
 * @version 1.0
 */
import java.sql.ResultSet;
import java.sql.SQLException;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Shelter{

	private int careNo;
	private String name;
	private String adress;
	private String tel;
	private String closeday;
	private int mans;
	private String open;
	private String close;
	private String volunteerAm;
	private String volunteerPm;
	private String mapUrl;
	
}
