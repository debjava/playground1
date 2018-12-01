package com.ddlab.rnd.search;

import java.io.File;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class GetNoOfDocs {

	private static File indexDirPath = new File("multilocal/data");
	
	public static void main(String[] args) throws Exception {
		
		Directory dir = FSDirectory.open(indexDirPath.toPath());
		DirectoryReader ireader = DirectoryReader.open(dir);
		System.out.println(ireader.numDocs());

	}

}
