package com.n1books.dev.controller;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

@Component("service")
public class Text2SpeechServiceImpl 
	extends TextToSpeech
	implements Text2SpeechService {
	
	@Autowired
	private Text2SpeechDAO text2SpeechDAO;

	public Text2SpeechServiceImpl() {
		setUsernameAndPassword(
			"c58778da-81f2-47a4-991e-f99459a065d1", "NX0F8bca6WG2");
	}

	public List<Voice> getVoiceList() throws Exception {
		return getVoices().execute();
	}

	@Override
	public InputStream getSpeech(String statement, String voice) throws Exception {
		return synthesize(statement, new Voice(voice,null,null), AudioFormat.OGG).execute();
	}

	@Override
	public void insertText2Speech(Text2SpeechVO vo) throws Exception {
		text2SpeechDAO.insertText2Speech(vo);
	}

	@Override
	public List<Text2SpeechVO> getText2SpeechList() throws Exception {
		return text2SpeechDAO.getText2SpeechList();
	}

	@Override
	public void deleteText2Speech(int no) throws Exception {
		text2SpeechDAO.deleteText2Speech(no);
	}
}
