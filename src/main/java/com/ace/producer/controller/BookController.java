package com.ace.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ace.producer.vo.Book;

@RestController
@RequestMapping("/book")
@EnableBinding(Source.class)
public class BookController {

	@Autowired
	MessageChannel output;
	
	/*
	 * @Autowired Source source;
	 */

	
	@PostMapping(value = "/create")
	public ResponseEntity<String> createBook(@RequestBody Book book) { //
		output.send(MessageBuilder.withPayload(book).build()); // MessageChannel
		// output = bookStream.outputBoundBooks();
		//output.send(MessageBuilder.withPayload(book)
				//.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE).build());
		return new ResponseEntity<String>("created", HttpStatus.OK);
	}
	  
	
	/*
	 * @PostMapping(value = "/create") public ResponseEntity<String>
	 * createBook(@RequestBody Book book) { //
	 * output.send(MessageBuilder.withPayload(book).build()); MessageChannel
	 * //output = bookStream.outputBoundBooks();
	 * source.output().send(MessageBuilder.withPayload("hiiiiiiiiiiiiiiiiii").build(
	 * )); return new ResponseEntity<String>("created", HttpStatus.OK); }
	 */
}
