package com.example.demo.TinyURL.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.TinyURL.Entity.TinyUrl;
import com.example.demo.TinyURL.Repository.TinyUrlRepository;

import io.seruco.encoding.base62.Base62;

@Service
public class TinyUrlService{

//	private TinyUrlRepository tinyUrlRepository;
	private final Map<String, String> tinyUrlMap = new HashMap<>();
	private final Base62 base62 = Base62.createInstance();
	private TinyUrlRepository tinyUrlRepository;
	@Autowired
    public TinyUrlService(TinyUrlRepository tinyUrlRepository) {
        this.tinyUrlRepository = tinyUrlRepository;
    }

	// Base62
	public String createBaseTinyUrl(String originalUrl) {
		byte[] originalUrlBytes = originalUrl.getBytes();
		byte[] encodedBytes = base62.encode(originalUrlBytes);
		String tinyUrl = new String(encodedBytes);
		tinyUrlMap.put(tinyUrl, originalUrl);
		return tinyUrl;
	}
	
	public String getBaseOriginalUrl(String tinyUrl) {
		return tinyUrlMap.get(tinyUrl);
	}

	// Hash MD5
	public String createHashTinyUrl(String originalUrl) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(originalUrl.getBytes());
		byte[] digest = md.digest();
		StringBuilder sb = new StringBuilder();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		String hash = sb.toString();
		String shortURL = hash.substring(0, 6);
		tinyUrlMap.put(shortURL, originalUrl);
		return shortURL;
	}

	public String getHashOriginalUrl(String tinyUrl) {
		return tinyUrlMap.get(tinyUrl);
	}
	
	// Random
	
	public String createRandomTinyUrl(String originalUrl) {
		String tinyUrl="";
		boolean isUnique = false;
		while (!isUnique) {
			tinyUrl = getRandomString();
			TinyUrl existingUrl =  tinyUrlRepository.findByShortUrl(tinyUrl);
			if (existingUrl != null) {
				break;
			}
		}
		TinyUrl newUrl = new TinyUrl(null, tinyUrl,originalUrl);
		tinyUrlRepository.save(newUrl);
		return tinyUrl;
	}
	
	public TinyUrl getTinyUrlByShortUrl(String shortUrl) {
            return tinyUrlRepository.findByShortUrl(shortUrl);
    	}

	private String getRandomString() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			int index = random.nextInt(allowedChars.length());
			sb.append(allowedChars.charAt(index));
		}
		return sb.toString();
	}
	



}
