package tteogipbangbeomdae.goddog.web.common.filehandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import tteogipbangbeomdae.goddog.domain.file.dto.UploadFile;

/**
 * 파일 업로드 처리 및 관리
 */
@Component
@Slf4j
public class FileStore {

	//  @Value("${file.dir}")
//	@Value("C:/ezen-fullstack/workspace/goddog/upload")

	@Value("${common.uploadPath}")
	private String location;

	public String getFullPath(String filename) {
		return location + filename;
	}

	// 파일 저장
	public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {

		List<UploadFile> storeFileResult = new ArrayList<UploadFile>();
		for (MultipartFile multipartFile : multipartFiles) {

			if (!multipartFile.isEmpty()) {
				//업로드 파일 저장
				UploadFile uploadFile = storeFile(multipartFile);
				storeFileResult.add(uploadFile);
			}
		}
		return storeFileResult;

	}

	public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
		if (multipartFile == null || multipartFile.isEmpty()) {
			return null;
		}
		
		String originalFilename = multipartFile.getOriginalFilename();
		String storeFileName = createStoreFileName(originalFilename);
		log.info("사용자가 업로드한 파일명: {}", originalFilename);
		log.info("실제 저장된 파일명: {}", storeFileName);
		multipartFile.transferTo(new File(getFullPath(storeFileName)));
		return new UploadFile(originalFilename, storeFileName);
	}

	// 파일 중복 체크
	private String createStoreFileName(String originalFilename) {
		String ext = extractExt(originalFilename);
		String uuid = UUID.randomUUID().toString();
		return originalFilename + "-" + uuid + "." + ext;
	}

	private String extractExt(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		return originalFilename.substring(pos + 1);
	}
}
