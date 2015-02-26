package com.newsio.utility;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;

public class DataPersister {
	public static final String acckey = 
			"fKdxSzHBYbWe2L6+ZxDylPFobY4meI4SqUwTkD+bNcM+fxc+Wec808foKi8Ppcb52Ni8AotOv5yh9oMMvf/D2Q==";
	public static final String accname = "newscrawl";
	public static final String storageConnectionString = 
			"DefaultEndpointsProtocol=http;" + 
					"AccountName=" + accname +";"+
					"AccountKey="+ acckey;
	public static void persist(String what, String blobName)
	{
		persist(what, blobName, false);
	}
	public static void persist(String what, String blobName, boolean isTest)
	{
		try {
			CloudStorageAccount storageAccount = CloudStorageAccount.
					parse(storageConnectionString);
			CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
			String containerName = null;
			if(isTest)
			{
				containerName = "test_container";
			}
			else
			{
				containerName = "news_bucket";
			}
			// Get a reference to a container.
			// The container name must be lower case
			CloudBlobContainer container = blobClient.
					getContainerReference(containerName);
			container.createIfNotExists();
			CloudBlockBlob blob = container.getBlockBlobReference(blobName);
			blob.uploadText(what);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
