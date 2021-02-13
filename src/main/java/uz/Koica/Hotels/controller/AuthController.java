package uz.Koica.Hotels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.Koica.Hotels.entity.*;
import uz.Koica.Hotels.payload.Result;
import uz.Koica.Hotels.payload.TourReq;
import uz.Koica.Hotels.repository.HotelCommentRepository;
import uz.Koica.Hotels.service.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private HotelCommentService hotelCommentService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private TourService tourService;
    @Autowired
    private TypeService typeService;

    //region FileController
    @PostMapping("/file/save")
    public ResponseEntity<Result> FileSave(@RequestParam(name = "file") MultipartFile multipartFile){
        return ResponseEntity.ok(attachmentService.save(multipartFile));
    }
    @DeleteMapping("/file/delete/{hashCode}")
    public ResponseEntity<Result> FileDelete(@PathVariable String hashCode){
        return ResponseEntity.ok(attachmentService.delete(hashCode));
    }
    @GetMapping("/file/preview/{hashCode}")
    public ResponseEntity<InputStreamResource> FilePreview(@PathVariable String hashCode, HttpServletResponse response) throws IOException {
        assert hashCode != null;
        return attachmentService.getFile(hashCode, response);
    }
    @GetMapping("/file/getPage")
    public ResponseEntity<Page<Attachment>> FileGetPage(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(attachmentService.findFilePage(page, size));
    }
    //endregion

    //region Country
    @PostMapping("/country/save")
    public ResponseEntity<Result> CountrySave(@RequestBody Country country){
        return ResponseEntity.ok(countryService.save(country));
    }
    @PostMapping("/country/edit/{id}")
    public ResponseEntity<Result> CountryEdit(@RequestBody Country country, @PathVariable Long id){
        return ResponseEntity.ok(countryService.edit(country, id));
    }
    @DeleteMapping("/country/delete/{id}")
    public ResponseEntity<Result> CountryDelete(@PathVariable Long id){
        return ResponseEntity.ok(countryService.delete(id));
    }
    @GetMapping("/country/getAll")
    public ResponseEntity<List<Country>> CountryGetPage(){
        return ResponseEntity.ok(countryService.getAll());
    }
    //endregion

    //region HotelComment
    @PostMapping("/hotelComment/save")
    public ResponseEntity<Result> HotelCommentSave(@RequestBody HotelComment hotelComment){
        return ResponseEntity.ok(hotelCommentService.save(hotelComment));
    }
    @PostMapping("/hotelComment/edit/{id}")
    public ResponseEntity<Result> HotelCommentEdit(@RequestBody HotelComment hotelComment, @PathVariable Long id){
        return ResponseEntity.ok(hotelCommentService.edit(hotelComment, id));
    }
    @DeleteMapping("/hotelComment/delete/{id}")
    public ResponseEntity<Result> HotelCommentDelete(@PathVariable Long id){
        return ResponseEntity.ok(hotelCommentService.delete(id));
    }
    @GetMapping("/hotelComment/getAll")
    public ResponseEntity<List<HotelComment>> HotelCommentGetPage(){
        return ResponseEntity.ok(hotelCommentService.getAll());
    }
    //endregion

    //region HotelService
    @PostMapping("/hotel/save")
    public ResponseEntity<Result> HotelSave(@RequestBody Hotel hotel){
        return ResponseEntity.ok(hotelService.save(hotel));
    }
    @PostMapping("/hotel/edit/{id}")
    public ResponseEntity<Result> HotelEdit(@RequestBody Hotel hotel, @PathVariable Long id){
        return ResponseEntity.ok(hotelService.edit(hotel, id));
    }
    @DeleteMapping("/hotel/delete/{id}")
    public ResponseEntity<Result> HotelDelete(@PathVariable Long id){
        return ResponseEntity.ok(hotelService.delete(id));
    }
    @GetMapping("/hotel/getPage")
    public ResponseEntity<Page<Hotel>> HotelGetPage(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(hotelService.getPage(page, size));
    }
    //endregion

    //region Tour
    @PostMapping("/tour/save")
    public ResponseEntity<Result> TourSave(@RequestBody TourReq tour){
        return ResponseEntity.ok(tourService.save(tour));
    }
    @PostMapping("/tour/edit/{id}")
    public ResponseEntity<Result> TourEdit(@RequestBody TourReq tour, @PathVariable Long id){
        return ResponseEntity.ok(tourService.edit(tour, id));
    }
    @DeleteMapping("/tour/delete/{id}")
    public ResponseEntity<Result> TourDelete(@PathVariable Long id){
        return ResponseEntity.ok(tourService.delete(id));
    }
    @GetMapping("/tour/getPage")
    public ResponseEntity<Page<Tour>> TourGetPage(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(tourService.getPage(page, size));
    }
    //endregion

    //region Type
    @PostMapping("/type/save")
    public ResponseEntity<Result> TypeSave(@RequestBody Type type){
        return ResponseEntity.ok(typeService.save(type));
    }
    @PostMapping("/type/edit/{id}")
    public ResponseEntity<Result> TypeEdit(@RequestBody Type type, @PathVariable Long id){
        return ResponseEntity.ok(typeService.edit(type, id));
    }
    @DeleteMapping("/type/delete/{id}")
    public ResponseEntity<Result> TypeDelete(@PathVariable Long id){
        return ResponseEntity.ok(typeService.delete(id));
    }
    @GetMapping("/type/getPage")
    public ResponseEntity<List<Type>> TypeGetPage(){
        return ResponseEntity.ok(typeService.getAll());
    }
    //endregion


}
