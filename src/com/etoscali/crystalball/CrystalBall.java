package com.etoscali.crystalball;

import java.util.Random;

public class CrystalBall {
	//Member variables properties about the object
	public String[] mAnswers = {
			
			"Kesinlikle",
			"Kesinlikle öyle",
			"Kuþkusuz",
			"Elbette",
			"Bana güvenebilirsin",
			"Gördüðüm kadarýyla, evet",
			"Çoðunlukla",
			"Dýþarýdan iyi görünüyor",
			"Evet",
			"Belirtiler olduðu yönünde",
			"Biraz belirsiz, tekrar dene",
			"Sonra tekrar dene",
			"Þimdi söylemesem daha iyi",
			"Þimdi kehanette bulunamam",
			"Konsantre ol ve tekrar sor",
			"Yanýtým hayýr",
			"Kaynaklarým hayýr diyor",
			"Pek iyi görünmüyor",
			"Çok þüpheli"
			
	};
	//methods :abilities
	public String getAnAnswer(){
		
		String answer = null;
		
		//randomly selected answers for every one of questions yes no or maybe
		Random randomGenerator = new Random();
		int randomNumber = randomGenerator.nextInt(mAnswers.length);
		answer = mAnswers[randomNumber];
		
		return answer;
		
	}
	
	

}
