package com.newsio.utility;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.newsio.types.NewsStorageFile;
import com.newsio.types.NewsStorageItem;

public class DataTransporter {
	//public static NewsStorageFile container;
	public static ArrayList<NewsStorageItem> container
	 = new ArrayList<NewsStorageItem>() ;

	public static void addToContainer(NewsStorageItem item)
	{
		container.add(item);
	}
	public static void persistContainer()
	{
		Gson gson = new Gson();
		String ret = gson.toJson(container);
		container = new ArrayList<NewsStorageItem>();
		System.out.println(ret);
	}
}
