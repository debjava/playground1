package com.ddlab.rnd.multi;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class MultiDataStore {

	private static AtomicLong atomicId = new AtomicLong();
	
    private static File indexDirPath = new File("multilocal/data");

    public static IndexWriter getIndexWriter() throws Exception {
        Directory indexDir = FSDirectory.open(indexDirPath.toPath());
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        IndexWriter writer = new IndexWriter(indexDir, iwc);

        return writer;
    }

    public static void storeDocs(IndexWriter writer) throws Exception {
        ExecutorService exService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            String zipCode = "ZIP" + String.format("%05d", i);
            MultiLuceneIndexer multiLuceneIndexer = new MultiLuceneIndexer(writer,zipCode,atomicId);
            exService.execute(multiLuceneIndexer);
        }
        while (!exService.isTerminated())
            exService.shutdown();
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        IndexWriter writer = getIndexWriter();
        
        storeDocs(writer);

        writer.close();
        System.out.println("Indexing completed successfully ...");
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        long minutes = TimeUnit.MINUTES.convert(duration, TimeUnit.NANOSECONDS);
        long seconds = TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
        System.out.println("Total time taken :::" + minutes + " minutes" + " OR " + seconds + " " +
                "seconds");

    }
}
