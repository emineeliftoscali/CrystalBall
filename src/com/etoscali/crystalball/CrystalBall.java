package com.etoscali.crystalball;

import java.util.Random;

public class CrystalBall {
	//Member variables properties about the object
	public String[] mAnswers = {
			
			"Kesinlikle",
			"Kesinlikle �yle",
			"Ku�kusuz",
			"Elbette",
			"Bana g�venebilirsin",
			"G�rd���m kadar�yla, evet",
			"�o�unlukla",
			"D��ar�dan iyi g�r�n�yor",
			"Evet",
			"Belirtiler oldu�u y�n�nde",
			"Biraz belirsiz, tekrar dene",
			"Sonra tekrar dene",
			"�imdi s�ylemesem daha iyi",
			"�imdi kehanette bulunamam",
			"Konsantre ol ve tekrar sor",
			"Yan�t�m hay�r",
			"Kaynaklar�m hay�r diyor",
			"Pek iyi g�r�nm�yor",
			"�ok ��pheli"
			
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
