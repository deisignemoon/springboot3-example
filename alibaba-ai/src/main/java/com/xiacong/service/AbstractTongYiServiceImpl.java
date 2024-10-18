package com.xiacong.service;

import java.util.List;
import java.util.Map;

import com.xiacong.models.ActorsFilms;
import com.xiacong.models.Completion;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.image.ImageResponse;

/**
 * @author yuluo
 * @author <a href="mailto:yuluo08290126@gmail.com">yuluo</a>
 * @since 2023.0.0.0
 */

public abstract class AbstractTongYiServiceImpl implements TongYiService {

	private static final String INFO_PREFIX = "please implement ";
	private static final String INFO_SUFFIX = "() method.";

	@Override
	public String completion(String message) {

		throw new RuntimeException(INFO_PREFIX + Thread.currentThread().getStackTrace()[2].getMethodName());
	}

	@Override
	public Map<String, String> streamCompletion(String message) {

		throw new RuntimeException(INFO_PREFIX + Thread.currentThread()
				.getStackTrace()[2].getMethodName() + INFO_SUFFIX);
	}

	@Override
	public ActorsFilms genOutputParse(String actor) {

		throw new RuntimeException(INFO_PREFIX + Thread.currentThread()
				.getStackTrace()[2].getMethodName() + INFO_SUFFIX);
	}

	@Override
	public AssistantMessage genPromptTemplates(String adjective, String topic) {

		throw new RuntimeException(INFO_PREFIX + Thread.currentThread()
				.getStackTrace()[2].getMethodName() + INFO_SUFFIX);
	}

	@Override
	public AssistantMessage genRole(String message, String name, String voice) {

		throw new RuntimeException(INFO_PREFIX + Thread.currentThread()
				.getStackTrace()[2].getMethodName() + INFO_SUFFIX);
	}

	@Override
	public Completion stuffCompletion(String message, boolean stuffit) {

		throw new RuntimeException(INFO_PREFIX + Thread.currentThread()
				.getStackTrace()[2].getMethodName() + INFO_SUFFIX);
	}

	@Override
	public ImageResponse genImg(String imgPrompt) {

		throw new RuntimeException(INFO_PREFIX + Thread.currentThread()
				.getStackTrace()[2].getMethodName() + INFO_SUFFIX);
	}

	@Override
	public String genAudio(String text) {

		throw new RuntimeException(INFO_PREFIX + Thread.currentThread()
				.getStackTrace()[2].getMethodName() + INFO_SUFFIX);
	}

	@Override
	public List<Double> textEmbedding(String text) {

		throw new RuntimeException(INFO_PREFIX + Thread.currentThread()
				.getStackTrace()[2].getMethodName() + INFO_SUFFIX);
	}

	@Override
	public String audioTranscription(String url) {

		throw new RuntimeException(INFO_PREFIX + Thread.currentThread()
				.getStackTrace()[2].getMethodName() + INFO_SUFFIX);
	}

}