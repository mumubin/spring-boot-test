package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.sql.DataSource;

/**
 * Created by hzhubin15 on 2016/8/19.
 */

public class StartupRunner implements CommandLineRunner {
	protected final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {
		log();
	}

//	@Scheduled(initialDelay = 1000,fixedRate = 10000)
	private void log(){
		logger.info("hello");
		logger.info("DataSource" + " : " + dataSource.toString());
	}
}
