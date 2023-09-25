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
 *
 * @author  떡잎방범대 최은비
 * @since   2023. 9. 18.
 * @version 1.0
 */

@Component
public class FileStore {

	@Value("${common.uploadPath}")
	private String location = "C:/ezen_fullstack/workspace/goddog/upload/";

	public String getFullPath(String filename) {
		return location + filename;
	}

	/**
	 * 파일 저장
	 */
	public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {

		List<UploadFile> storeFileResult = new ArrayList<UploadFile>();
		for (MultipartFile multipartFile : multipartFiles) {

			if (!multipartFile.isEmpty()) {
				UploadFile uploadFile = storeFile(multipartFile);
				storeFileResult.add(uploadFile);
			}
		}
		return storeFileResult;
	}

	/**
	 * 파일명 처리
	 */
	public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
		if (multipartFile == null || multipartFile.isEmpty()) {
			return null;
		}
		
		String originalFilename = multipartFile.getOriginalFilename();
		multipartFile.transferTo(new File(getFullPath(originalFilename)));
		return new UploadFile(originalFilename, originalFilename);
	}
}
