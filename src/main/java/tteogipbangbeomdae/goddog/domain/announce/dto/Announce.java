package tteogipbangbeomdae.goddog.domain.announce.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Announce DTO클래스
 * @author 신혜원
 * build어노테이션 사용.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Announce {
	
	private int annoNo;
	private String title;
	private String contents;
	
}
