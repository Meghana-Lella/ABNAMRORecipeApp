package com.cg.recipeApp.exception;

public class RecipeNotFoundException extends Exception{
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public RecipeNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
}
