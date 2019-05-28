package com.smart.cloud.smartmodulesentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.cloud.alibaba.sentinel.rest.SentinelClientHttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

/**
 * @author fangjian
 */
public class ExceptionUtil {

	public static String handleException(BlockException ex) {
		System.out.println("Oops: " + ex.getClass().getCanonicalName());
		return "custom block info";
	}

}
