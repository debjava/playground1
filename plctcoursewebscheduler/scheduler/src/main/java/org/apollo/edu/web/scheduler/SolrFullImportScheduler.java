package org.apollo.edu.web.scheduler;

import org.apollo.edu.config.BaseConfig;
import org.apollo.edu.config.SolrConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@Import({BaseConfig.class})
public class SolrFullImportScheduler {
	
	protected static Logger logger = LoggerFactory.getLogger(SolrFullImportScheduler.class);
	
	@Autowired
	private SolrConfig solrConfig;
	
	@Scheduled(cron = "${cron.expression}")
	public void runFullImport() {
		logger.debug(" SOLR Full Import started ....");
		System.out.println("I am the different scheduler, I run through annotations ....");
		System.out.println("URL :::"+solrConfig.getSolrDeltaImportUrl());
	}

}
