package com.vallegrande.order.infraestructure.feign;

import com.vallegrande.order.infraestructure.feign.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service")
public interface BookClientFeign {

    @GetMapping(value = "/book/{isbn}")
    BookDto findItemByIsbn(@PathVariable String isbn);

}
