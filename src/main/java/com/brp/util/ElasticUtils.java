package com.brp.util;

import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * elastic工具类
 *
 */
public class ElasticUtils {

    private static  final Logger LOG = LoggerFactory.getLogger(ElasticUtils.class);

    private static Client client=null;

    static {
        try {

            Settings settings=Settings.settingsBuilder().put("cluster.name",ConfigUtils.getString("es.cluster.name")).put("client.transport.sniff", true).build();
            client = TransportClient.builder().settings(settings).build().addTransportAddress(
                    new InetSocketTransportAddress(InetAddress.getByName(ConfigUtils.getString("es.host")), ConfigUtils.getInt("es.port")));
        } catch (UnknownHostException e) {
            LOG.error("elasticsearch init fail",e);
            e.printStackTrace();
        }
	}

	public static boolean createIndex(String indexName) {
		boolean r = false;
		IndicesExistsResponse request = client.admin().indices().prepareExists(indexName).execute().actionGet();
		if (!request.isExists()) {
			CreateIndexResponse res = client.admin().indices().prepareCreate(indexName).execute().actionGet();
			if (res != null)
				r = true;
		}
		return r;
	}

    public static SearchHits queryData(QueryBuilder queryBuilder,String index,String type){
        SearchResponse searchResponse = client.prepareSearch(index).setTypes(type)
                .setQuery(queryBuilder)
                .execute()
                .actionGet();
        SearchHits hits = searchResponse.getHits();
        return hits;
    }

    /**
     * 查询索引是否存在
     * @param index
     * @return
     */
    public static boolean isExistsIndex(String index){
        return client.admin().indices().prepareExists(index).execute().actionGet().isExists();
    }

    public static void main(String[] args) {
      System.out.println(queryData(null,"logstash-2016.06.27","aps.log"));
	}
}
