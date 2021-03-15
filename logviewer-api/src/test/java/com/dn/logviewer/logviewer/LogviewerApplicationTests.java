package com.dn.logviewer.logviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.dn.logviewer.domain.Report;
import com.dn.logviewer.service.TextLogReportService;
import com.dn.logviewer.util.matchers.FinishRenderingMatcher;
import com.dn.logviewer.util.matchers.GetRenderingMatcher;
import com.dn.logviewer.util.matchers.StartRenderingMatcher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * Test class for report log generation
 * @author Emanoel de Lima
 */
@SpringBootTest
class LogviewerApplicationTests {

	@Autowired
	private TextLogReportService service;

	@Test
	void contextLoads() {
	}

	@Test
	public void shouldGenerateLogFromFile() throws IOException {
		MultipartFile multipartFile = new MockMultipartFile("test-log.log", new FileInputStream(new File("src/main/resources/test/test-log.log")));
		Report r = service.generateReport(multipartFile);
		assertEquals(r.getSummary().getCount(), 365);
		assertEquals(r.getSummary().getDuplicates(), 17);
		assertEquals(r.getSummary().getUnecessary(), 168);
	}

	@Test
	public void shouldMatchStartRendering() {
		String logLine = "2010-10-06 09:02:13,631 [WorkerThread-2] INFO  [ServiceProvider]: Executing request startRendering with arguments [114466, 0] on service object { ReflectionServiceObject -> com.dn.gaverzicht.dms.services.DocumentService@4a3a4a3a }";
		StartRenderingMatcher matcher = new StartRenderingMatcher();
		assertEquals(matcher.match(logLine), true);
	}

	@Test
	public void shouldMatchFinishRendering() {
		String logLine = "2010-10-06 09:02:13,634 [WorkerThread-2] INFO  [ServiceProvider]: Service startRendering returned 1286373733634-5423";
		FinishRenderingMatcher matcher = new FinishRenderingMatcher();
		assertEquals(matcher.match(logLine), true);
	}

	@Test
	public void shouldMatchGetRendering() {
		String logLine = "2010-10-06 09:02:14,825 [WorkerThread-0] INFO  [ServiceProvider]: Executing request getRendering with arguments [1286373733634-5423] on service object { ReflectionServiceObject -> com.dn.gaverzicht.dms.services.DocumentService@4a3a4a3a }";
		GetRenderingMatcher matcher = new GetRenderingMatcher();
		assertEquals(matcher.match(logLine), true);
	}

}
