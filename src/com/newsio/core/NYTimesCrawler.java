package com.newsio.core;

import java.util.Iterator;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.newsio.types.NewsStorageItem;
import com.newsio.utility.DataTransporter;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class NYTimesCrawler extends WebCrawler {

	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpe?g"
			+ "|png|mp3|mp3|zip|gz))$");

	/**
	 * This method receives two parameters. The first parameter is the page
	 * in which we have discovered this new url and the second parameter is
	 * the new url. You should implement this function to specify whether
	 * the given url should be crawled or not (based on your crawling logic).
	 * In this example, we are instructing the crawler to ignore urls that
	 * have css, js, git, ... extensions and to only accept urls that start
	 * with "http://www.ics.uci.edu/". In this case, we didn't need the
	 * referringPage parameter to make the decision.
	 */
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		String href = url.getURL().toLowerCase();
		return !FILTERS.matcher(href).matches()
				&& href.startsWith(referringPage.getWebURL().toString().
						toLowerCase());
	}

	private void ParseNews(Page page)
	{
		String headline = null;
		String news = null;
		String path = page.getWebURL().getPath().toLowerCase() ;
		HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
		String htm = htmlParseData.getHtml();
		Document doc = Jsoup.parse(htm);
		String className = "story-body-text";
		Elements elems = doc.getElementsByClass(className);
		if (elems.size()!=0) {
			System.out.println("yes! thats a news!");
			Iterator<Element> it = elems.iterator();
			while (it.hasNext()) {
				Element elem = it.next();
				news += elem.text();
			}
		}
		else
		{
			System.out.println("It isn't a news page");
			return;
		}
		String id = "story-heading";
		Element elem = doc.getElementById(id );
		headline = elem.text();
		NewsStorageItem item = new NewsStorageItem();
		item.setHeadLine(headline);
		item.setDetailsNews(news);
		item.setPath(path);
		DataTransporter.addToContainer(item);
		if(DataTransporter.container.size()>2)
		{
			DataTransporter.persistContainer();
		}
	}
	/**
	 * This function is called when a page is fetched and ready
	 * to be processed by your program.
	 */
	@Override
	public void visit(Page page) {
		this.ParseNews(page);
		System.out.println("Visiting page"+ page.getWebURL().toString());
	}
}
