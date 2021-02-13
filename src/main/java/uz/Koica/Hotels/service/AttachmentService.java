package uz.Koica.Hotels.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import uz.Koica.Hotels.entity.Attachment;
import uz.Koica.Hotels.payload.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AttachmentService {
    Result save(MultipartFile multipartFile);
    Result delete(String hashCode);
    Attachment findByHashCode(String hashCode);
    ResponseEntity<InputStreamResource> getFile(String hashCode, HttpServletResponse response) throws IOException;
    Page<Attachment> findFilePage(int page, int size);
}
