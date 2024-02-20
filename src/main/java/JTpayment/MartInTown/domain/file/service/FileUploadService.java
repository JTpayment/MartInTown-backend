package JTpayment.MartInTown.domain.file.service;

import JTpayment.MartInTown.domain.file.presentation.response.FileUploadResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    FileUploadResponse execute(MultipartFile file);
}
