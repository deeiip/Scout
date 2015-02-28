# Dillinger

Crawler to crawl media websites

This simply crwals cnn, bbc, al jazeera and all affrica for news article and it corresponding headline. Mainly it extracts:

 - the headline
 - the article
 - publishing date
 - publish path (for importance analysis in future step)
 - publish url (I dont know why. But I feel I'll need this)
 
Thats all it stores the result as a list of json objects. Which will be used with hadoop clusters. Specifically I'll use hive
query to make sense from all of this.
