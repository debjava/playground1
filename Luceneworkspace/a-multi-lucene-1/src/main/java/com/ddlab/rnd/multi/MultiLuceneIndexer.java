package com.ddlab.rnd.multi;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;

import java.util.concurrent.atomic.AtomicLong;

public class MultiLuceneIndexer implements Runnable {

//	private AtomicLong idCounter = new AtomicLong();
	
	private AtomicLong idCounter = null;
	
	private IndexWriter writer;
	private String zipCode;

	public MultiLuceneIndexer(IndexWriter writer, String zipCode,AtomicLong idCounter) {
		this.writer = writer;
		this.zipCode = zipCode;
		this.idCounter = idCounter;
	}

	private String getID() {
		return String.valueOf(idCounter.getAndIncrement());
	}

	public void addOrUpdateDocument(IndexWriter indexWriter, String id, String zipCode, String courseCode)
			throws Exception {
		Document doc = new Document();
		System.out.println(id + "---" + zipCode + "---" + courseCode);
		doc.add(new StringField("id", id, Field.Store.YES));
		doc.add(new StringField("zipCode", zipCode, Field.Store.YES));
		doc.add(new StringField("courseCode", courseCode, Field.Store.YES));
		// For full text search
		String fullSearchableText = id + " " + zipCode + " " + courseCode;
		doc.add(new TextField("content", fullSearchableText, Field.Store.NO));

		// indexWriter.addDocument(doc);
		// indexWriter.updateDocument(new Term("id", id), doc);

		if (indexWriter.getConfig().getOpenMode() == IndexWriterConfig.OpenMode.CREATE) {
			System.out.println("Adding docs...");
			indexWriter.addDocument(doc);
		} else {
			System.out.println("Updating docs...");
			indexWriter.updateDocument(new Term("id", id), doc);
		}

		indexWriter.commit();
		indexWriter.flush();
	}

	public void addOrUpdateDocument(IndexWriter indexWriter, String zipCode, String courseCode)
			throws Exception {
		Document doc = new Document();
//		String id = getID();
		
		String id = String.valueOf(idCounter.getAndIncrement());
		
		System.out.println(id + "---" + zipCode + "---" + courseCode);
		doc.add(new StringField("id", id, Field.Store.YES));
		doc.add(new StringField("zipCode", zipCode, Field.Store.YES));
		doc.add(new StringField("courseCode", courseCode, Field.Store.YES));
		// For full text search
		String fullSearchableText = id + " " + zipCode + " " + courseCode;
		doc.add(new TextField("content", fullSearchableText, Field.Store.NO));

		if (indexWriter.getConfig().getOpenMode() == IndexWriterConfig.OpenMode.CREATE) {
			System.out.println("Adding docs...");
			indexWriter.addDocument(doc);
		} else {
			System.out.println("Updating docs...");
			indexWriter.updateDocument(new Term("id", id), doc);
		}

		indexWriter.commit();
		indexWriter.flush();
	}

	public void run() {
		for (int j = 0; j < 20; j++) {
			String courseCode = "COURSE" + String.format("%05d", j);
//			String id = getID();
			// System.out.println(id + "-" + zipCode + "<---->" + courseCode);
			try {
//				addOrUpdateDocument(writer, id, zipCode, courseCode);
				addOrUpdateDocument(writer, zipCode, courseCode);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
