package com.newsio.core;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import com.newsio.types.NewsSource;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class ScoutController {
	public static PrintWriter out;
	public static Object printerLock = new Object();
	public void open()
	{
		System.out.println("[");
	}
	public void close()
	{
		System.out.println("\b]");
	}
	public void startCrawlFor(NewsSource src) throws Exception
	{
		String crawlStorageFolder = "c:/data2/bbccrawl/root";
		
        int numberOfCrawlers = 100;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        //controller.addSeed("http://www.ics.uci.edu/~lopes/");
        //controller.addSeed("http://www.ics.uci.edu/~welling/");
        if(src == NewsSource.BBC)
        {
        	controller.addSeed("http://www.bbc.com/");
            /*
             * Start the crawl. This is a blocking operation, meaning that your code
             * will reach the line after this only when crawling is finished.
             */
            controller.start(BBCCrawler.class, numberOfCrawlers);
            //out.close();
        }
        else if(src == NewsSource.TimesOfIndia)
        {
        	controller.addSeed("http://timesofindia.indiatimes.com/");
            
            /*
             * Start the crawl. This is a blocking operation, meaning that your code
             * will reach the line after this only when crawling is finished.
             */
            controller.start(TimesOfIndiaCrawler.class, numberOfCrawlers);
            //out.close();
        }
        
	}

}
