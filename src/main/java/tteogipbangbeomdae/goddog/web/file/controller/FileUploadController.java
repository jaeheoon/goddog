package tteogipbangbeomdae.goddog.web.file.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.file.dto.MemberForm;
import tteogipbangbeomdae.goddog.domain.file.dto.UploadFile;
import tteogipbangbeomdae.goddog.web.common.filehandler.FileStore;

/**
 * 
 * /article요청에 대한 세부 컨트롤러 요청된 url에 따라 해당하는 DB작업을 이루고 템플릿으로 연동시켜줌.
 *
 * @author  떡잎방범대 조영호
 * @since   2023. 09. 10.
 * @version 1.0
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class FileUploadController {

	@Value("${common.uploadPath}")
	private String location;
	
	private final FileStore fileStore;

	// 파일 업로드 화면 요청
	@GetMapping("/upload")
	public String uploadForm() {
		return "form";
	}
	
	@PostMapping("/upload")
	public String uploadFiles(@ModelAttribute MemberForm memberForm, RedirectAttributes redirectAttributes) throws IOException {
				
				// 테스트시
				log.info("업로드 파일: {}", memberForm.getUploadfiles());

				List<UploadFile> uploadFiles = fileStore.storeFiles(memberForm.getUploadfiles());
				
				log.info("저장된파일명 : {}", uploadFiles);
				
				// 데이터베이스에 오리지날파일명과 저장파일명 저장 후(테이블의 컬럼이 2개 필요)
				redirectAttributes.addFlashAttribute("uploader", memberForm.getUploader());
				redirectAttributes.addFlashAttribute("uploadfiles", uploadFiles);
				return "redirect:upload-result2";
	}
	
	@GetMapping("/upload-result2")
	public String uploadResult() {
		return "upload-result2";

	}
	
	//동적 이미지의 경우 출력
	@GetMapping("/images/{name}")
	@ResponseBody
	public ResponseEntity<Resource> showImage(@PathVariable String name) throws IOException {

		Path path = Paths.get(location + "/" + name);
		String contentType = Files.probeContentType(path);
		Resource resource = new FileSystemResource(path);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

	}
	
	
}