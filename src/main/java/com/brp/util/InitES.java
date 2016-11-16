package com.brp.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.ListenableActionFuture;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.Settings.Builder;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.http.JestHttpClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by Administrator on 2016/6/30.
 */
public class InitES {

	private static final Logger LOG = LoggerFactory.getLogger(InitES.class);

	private static JestHttpClient client = null;

	private static Client esClient;

	/**
	 * 配置jest客户端
	 *
	 * @return
	 */
	static {
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder(ConfigUtils.getString("es.url")).build());
		client = (JestHttpClient) factory.getObject();
		Builder settings = Settings.builder();
		try {
			esClient = TransportClient.builder().settings(settings).build()
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static int queryDataCount(String query, String index, String type) {
		JestResult jestReslut = null;
		try {
			jestReslut = client.execute(new Search.Builder(query).addIndex(index).addType(type).build());
		} catch (IOException e) {
			LOG.error("elasticsearch query error", e);
			e.printStackTrace();
		}
		SearchResult searchResult = new SearchResult(new Gson());
		searchResult.setSucceeded(true);
		searchResult.setJsonString(jestReslut.getJsonString());
		searchResult.setJsonObject(new JsonParser().parse(jestReslut.getJsonString()).getAsJsonObject());
		searchResult.setPathToResult("hits/hits/_source");
		return searchResult.getTotal() == null ? 0 : searchResult.getTotal();

	}

	public static Map<String, Object> getRemoteCount() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		SearchRequestBuilder builder = esClient.prepareSearch("db").setTypes("user");
		builder.setSearchType(SearchType.QUERY_THEN_FETCH);
		BoolQueryBuilder must = new BoolQueryBuilder().must(QueryBuilders.matchQuery("code", 200))
				.must(QueryBuilders.matchQuery("name", "xxxx"));
		builder.setQuery(must);
		ListenableActionFuture<SearchResponse> execute = builder.execute();
		SearchResponse actionGet = execute.actionGet();
		SearchHits hits = actionGet.getHits();
		resultMap.put("successCount", hits.getTotalHits());
		builder.setQuery(new BoolQueryBuilder());
		ListenableActionFuture<SearchResponse> execute2 = builder.execute();
		long totalHits = execute2.actionGet().getHits().getTotalHits();
		resultMap.put("totalCount", totalHits);
		resultMap.put("failCount", totalHits - hits.getTotalHits());
		return resultMap;
	}
}
