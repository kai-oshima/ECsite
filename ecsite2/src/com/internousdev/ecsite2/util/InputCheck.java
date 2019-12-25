package com.internousdev.ecsite2.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class InputCheck {

	public List<String> inputCheck(String type,String value,int min, int max,boolean alphabet,boolean kanji,boolean hiragana,boolean katakana,boolean number, boolean space) {

		List<String> messageList = new ArrayList<String>();
		List<String> checkList = new ArrayList<String>();

		String expression = "";

		//入力欄が空かどうかを検証します
				if(StringUtils.isBlank(value)){
					// isBlank:キーワードが null,""," ","　"の時に空文字に設定する
					// スペースのみ入力されている場合は値を空にする
					value = "";
					messageList.add(type + "を入力してください。");
				}

		//入力値の長さチェック
		if(value.length() < min || value.length() > max) {

			messageList.add(type + "は" + min + "以上" + max + "以下で入力してください。");
		}


		if(alphabet ||  kanji || hiragana || katakana || number || space){
			expression= "[";
		}

		if(alphabet){
			expression +="a-zA-Z";
			checkList.add("半角英字");
		}

		if(kanji){
			expression +="一-龠々";
			checkList.add("漢字");
		}

		if(hiragana){
			expression +="ぁ-んー";
			checkList.add("ひらがな");
		}

		if(number){
			expression +="0-9-";
			checkList.add("半角数字");
		}

		if(katakana){
			expression +="ァ-ヺ";
			checkList.add("カタカナ");
		}

		if(space){
			expression +=" 　";
			checkList.add("スペース");
		}

		if(!StringUtils.isEmpty(expression)){
			expression +="]+";
		}
		////////////////////////////ここまで///////////////////////////

		//判別した項目に応じてエラーメッセージを返します
		String characterType = "";

		for(int i = 0;i < checkList.size();i++){
			if(i == 0){
				characterType += checkList.get(i).toString();
			}else{
				characterType += "、" + checkList.get(i).toString();
			}
		}

		if(!value.matches(expression) && !"".equals(value)){
			messageList.add(type + "は" + characterType + "で入力してください。");
		}

		return messageList;
	}

	public List<String> doCheckForEmail(String value){

		//検証した結果を入れるList
		List<String> messageList = new ArrayList<String>();
		int minLength = 10;
		int maxLength = 32;
		String propertyName = "メールアドレス";


		//入力欄が空かどうかを検証します
		if(StringUtils.isEmpty(value)){
			messageList.add(propertyName + "を入力してください。");
		}

		//入力欄が最小文字数以上、最大文字数以下かどうかを検証します
		if(value.length() < minLength || value.length() > maxLength){
			messageList.add(propertyName + "は" + minLength + "文字以上" + maxLength + "文字以下で入力してください。");
		}

		///////////入力された文字のタイプから何を判別するか決めます//////////
		String regularExpression = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.]+(?:\\.[a-zA-Z0-9.]+)*$";
		////////////////////////////ここまで///////////////////////////

		//判別した項目に応じてエラーメッセージを返します
		String characterType = "[半角英字、半角数字、半角記号(_.-)]@[半角英字、半角数字、半角記号(.)]";

		if(!value.matches(regularExpression) && !"".equals(value)){
			messageList.add(propertyName + "は" + characterType + "で入力してください。");
		}

		return messageList;
	}
}
