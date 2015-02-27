package com.newsio.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.newsio.core.ScoutController;
import com.newsio.types.NewsSource;

public class ScoutControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void startCCrawlForTest() {
		ScoutController sc = new ScoutController();
		try {
			sc.startCrawlFor(NewsSource.TimesOfIndia);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
