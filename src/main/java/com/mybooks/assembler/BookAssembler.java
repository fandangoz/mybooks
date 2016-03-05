package com.mybooks.assembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.mybooks.ds.BookDs;
import com.mybooks.dto.BookDto;

/**
 * Class provides methods to transfer books from dto to ds or from ds into dto
 */
public class BookAssembler {

	public static BookDs dto2DsAssembler(BookDto dto) {
		if (null == dto) {
			return null;
		}
		BookDs ds = new BookDs();
		ds.setId(dto.getId());
		ds.setAuthor(dto.getAuthor());
		ds.setIsbn(dto.getIsbn());
		ds.setTitle(dto.getTitle());
		return ds;
	}

	public static List<BookDs> dto2DsAssembler(List<BookDto> dtos) {
		if (CollectionUtils.isEmpty(dtos)) {
			return Collections.emptyList();
		}
		List<BookDs> dses = new ArrayList<>(dtos.size());
		for (BookDto dto : dtos) {
			dses.add(dto2DsAssembler(dto));
		}
		return dses;
	}

	public static BookDto ds2DtoAssembler(BookDs ds) {
		if (null == ds) {
			return null;
		}
		BookDto dto = new BookDto();
		dto.setId(ds.getId());
		dto.setAuthor(ds.getAuthor());
		dto.setIsbn(ds.getIsbn());
		dto.setTitle(ds.getTitle());
		return dto;
	}
	
	public static List<BookDto> ds2DtoAssembler(List<BookDs> dses){
		if(CollectionUtils.isEmpty(dses)){
			return Collections.emptyList();
		}
		List<BookDto> dtos = new ArrayList<>(dses.size());
		for(BookDs ds : dses) {
			dtos.add(ds2DtoAssembler(ds));
		}
		return dtos;
	}
}
