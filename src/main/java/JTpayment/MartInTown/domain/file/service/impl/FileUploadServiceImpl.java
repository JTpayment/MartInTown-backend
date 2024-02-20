package JTpayment.MartInTown.domain.file.service.impl;

import JTpayment.MartInTown.domain.file.exception.FileUploadFailedException;
import JTpayment.MartInTown.domain.file.exception.InvalidFormatFileException;
import JTpayment.MartInTown.domain.file.exception.NotAllowedFileException;
import JTpayment.MartInTown.domain.file.presentation.response.FileUploadResponse;
import JTpayment.MartInTown.domain.file.service.FileUploadService;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    private static final List<String> ALLOWED_MIME_TYPES = Arrays.asList("image/jpg", "image/png", "image/gif");

    @Override
    public FileUploadResponse execute(MultipartFile file) {

        String fileName = createFileName(file.getOriginalFilename());

        String contentType = file.getContentType();

        if(!ALLOWED_MIME_TYPES.contains(contentType)) {
            throw new NotAllowedFileException();
        }

        ObjectMetadata objectMetadata = new ObjectMetadata();

        objectMetadata.setContentLength(file.getSize());

        objectMetadata.setContentType(contentType);

        try (InputStream inputStream = file.getInputStream()) {

            amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new FileUploadFailedException();
        }

        String fileUrl = generateFileUrl(fileName);

        return FileUploadResponse.builder()
                .url(fileUrl)
                .build();
    }

    private String createFileName(String fileName) {

        return UUID.randomUUID().toString().concat(getFileExtension(fileName));
    }

    private String getFileExtension(String fileName) {

        try {

            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {

            throw new InvalidFormatFileException();
        }
    }

    private String generateFileUrl(String fileName) {
        return amazonS3.getUrl(bucket, fileName).toString();
    }
}
