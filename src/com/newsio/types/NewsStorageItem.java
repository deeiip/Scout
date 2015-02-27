package com.newsio.types;

import com.google.gson.Gson;

public class NewsStorageItem {
	private String headLine;
	private String detailsNews;
	private String path;
	private String source;
	public String getHeadLine() {
		return headLine;
	}
	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}
	public String getDetailsNews() {
		return detailsNews;
	}
	public void setDetailsNews(String detailsNews) {
		this.detailsNews = detailsNews;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString()
	{
		Gson gson = new Gson();
		String str = gson.toJson(this);
		return str;
	}
	public boolean equals(Object obj)
	{
		if(obj instanceof NewsStorageItem)
		{
			NewsStorageItem item = (NewsStorageItem)obj;
			if((item.path.equals(this.path)))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}
