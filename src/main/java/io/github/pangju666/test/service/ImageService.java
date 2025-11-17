package io.github.pangju666.test.service;

import io.github.pangju666.framework.boot.image.core.ImageTemplate;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
	private final ImageTemplate<?> imageTemplate;

	public ImageService(ImageTemplate<?> imageTemplate) {
		this.imageTemplate = imageTemplate;
	}
}
