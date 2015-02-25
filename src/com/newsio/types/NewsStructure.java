package com.newsio.types;


import java.util.ArrayList;

import com.google.gson.Gson;


public class NewsStructure {
	
	private String ModuleName;
	private ArrayList<String> headLinePath;
	@Override
	public String toString()
	{
		Gson gson = new Gson();
		String jsonRep = gson.toJson(this);
		return jsonRep;
	}
	
	public String getModuleName() {
		return ModuleName;
	}
	public void setModuleName(String moduleName) {
		ModuleName = moduleName;
	}
	public ArrayList<String> getPath() {
		return headLinePath;
	}
	public void setPath(ArrayList<String> path) {
		headLinePath = path;
	}
	
	public static NewsStructure Parse(String json)
	{
		Gson gson = new Gson();
		NewsStructure ret = gson.fromJson(json, NewsStructure.class);
		return ret;
	}

}
