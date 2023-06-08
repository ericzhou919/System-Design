package com.example.demo.TinyURL.Controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.TinyURL.Entity.TinyUrl;
import com.example.demo.TinyURL.Service.TinyUrlService;

@RestController
@RequestMapping("/tinyurl")
//
public class TinyUrlController<T> {
	@Autowired
    private TinyUrlService tinyUrlService;

	@PostMapping("/base62")
	public ResponseEntity<Map<String, String>> createBaseTinyUrl(@RequestBody String req) {
		Map<String, String> data = new HashMap<>();
		System.out.println(req);
		String[] parts = req.split("=");
		String originalUrl = parts[1];
		String tinyUrl = tinyUrlService.createBaseTinyUrl(originalUrl);
		Map<String, String> jsonResponse = new HashMap<>();
		
		if (tinyUrl != null) {
			jsonResponse.put("message", "success");
			jsonResponse.put("tinyUrl", "http://localhost:8080/" + tinyUrl);
			return ResponseEntity.ok(jsonResponse);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
	}

	@GetMapping("/base62/{tinyUrl}")
	public ResponseEntity<Map<String, String>> getBaseOriginalUrl(@PathVariable String tinyUrl,
			HttpServletResponse response) throws IOException {
		String originalUrl = tinyUrlService.getBaseOriginalUrl(tinyUrl);
		Map<String, String> jsonResponse = new HashMap<>();
		if (originalUrl != null) {
			jsonResponse.put("message", "success");
			jsonResponse.put("originalUrl", originalUrl);
			return ResponseEntity.ok(jsonResponse);
		} else {
			jsonResponse.put("message", "originalUrl is null");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
		
	}

	@PostMapping("/hash")
	public ResponseEntity<Map<String, String>> createHashTinyUrl(@RequestBody String req)
			throws NoSuchAlgorithmException {
		Map<String, String> data = new HashMap<>();
		String[] parts = req.split("=");
		String originalUrl = parts[1];
		String tinyUrl = tinyUrlService.createHashTinyUrl(originalUrl);
		Map<String, String> jsonResponse = new HashMap<>();
		if (tinyUrl != null) {
			jsonResponse.put("message", "success");
			jsonResponse.put("tinyUrl", "http://localhost:8080/" + tinyUrl);
			return ResponseEntity.ok(jsonResponse);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
	}

	@GetMapping("/hash/{tinyUrl}")
	public ResponseEntity<Map<String, String>> getHashOriginalUrl(@PathVariable String tinyUrl,
			HttpServletResponse response) throws IOException {
		String originalUrl = tinyUrlService.getHashOriginalUrl(tinyUrl);
		Map<String, String> jsonResponse = new HashMap<>();
		if (originalUrl != null) {
			jsonResponse.put("message", "success");
			jsonResponse.put("originalUrl", originalUrl);
			return ResponseEntity.ok(jsonResponse);
		} else {
			jsonResponse.put("message", "originalUrl is null");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
	}

	// Random
	@PostMapping("/random")
	public ResponseEntity<Map<String, String>> createRandomTinyUrl(@RequestBody String req) {
		Map<String, String> data = new HashMap<>();
		String[] parts = req.split("=");
		String originalUrl = parts[1];
		String tinyUrl = tinyUrlService.createRandomTinyUrl(originalUrl);
		Map<String, String> jsonResponse = new HashMap<>();
		if (tinyUrl != null) {
			jsonResponse.put("message", "success");
			jsonResponse.put("tinyUrl", "http://localhost:8080/" + tinyUrl);
			return ResponseEntity.ok(jsonResponse);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
	}
	@GetMapping("/random")
	public ResponseEntity<TinyUrl> fetchDepartmentList(@RequestParam("short_url") String shortUrl) {
	    TinyUrl tinyUrl =  tinyUrlService.getTinyUrlByShortUrl(shortUrl);
	    if (tinyUrl == null) {
	        return ResponseEntity.noContent().build();
	    }
	    
	    return ResponseEntity.ok(tinyUrl);
	}
}
