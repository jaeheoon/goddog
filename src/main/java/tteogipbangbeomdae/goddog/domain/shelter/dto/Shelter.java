package tteogipbangbeomdae.goddog.domain.shelter.dto;
/**
 * @author  떡잎방범대 최은비
 * @since   2023. 9. 11.
 *  * @author  떡잎방범대 문승욱
 * @since   2023. 9. 21.
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
	private String introduction;
	private String etc;
	
	private int careImgNo;
	
	private String careImg;
	private String careImg1;
	private String careImg2;
	private String careImg3;
	private String careImg4;
	
	
}
