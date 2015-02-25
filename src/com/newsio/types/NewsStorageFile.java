package com.newsio.types;

import java.util.ArrayList;

import com.google.gson.Gson;

public class NewsStorageFile {
	private String source;
	private ArrayList<NewsStorageItem> newses;
	private String fileName;


	public void persist()
	{
		System.out.println(this.toString());
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public ArrayList<NewsStorageItem> getNewses() {
		return newses;
	}
	public void setNewses(ArrayList<NewsStorageItem> newses) {
		this.newses = newses;
	}
	public void addnews(NewsStorageItem item)
	{
		boolean test = newses.contains(item);
		boolean t = test;

		newses.add(item);
	}
	@Override
	public String toString()
	{
		Gson gson = new Gson();
		String ser = gson.toJson(this);
		return ser;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
