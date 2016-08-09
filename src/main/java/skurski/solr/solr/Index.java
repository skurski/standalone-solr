package skurski.solr.solr;


import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.stereotype.Service;
import skurski.solr.model.Searching;

import java.io.IOException;

@Service
public class Index {

    private SolrClient solr;

    public Index() throws SolrServerException, InterruptedException, IOException {
        initSolr();
    }

    public SolrClient getSolr() {
        return solr;
    }

    private void initSolr() throws IOException, SolrServerException,
            InterruptedException {

        String urlString = "http://localhost:8983/solr/db";
        solr = new HttpSolrClient.Builder(urlString).build();
    }

    public void importFullDb() throws IOException {
        ModifiableSolrParams params = new ModifiableSolrParams();

        params.set("qt", "/dataimport");
        params.set("command", "full-import");
        params.set("clean", "true");

        QueryResponse response = null;

        try {
            response = solr.query(params);
        } catch (SolrServerException e1) {
            e1.printStackTrace();
        }
        System.out.println(response);
    }

    public SolrDocumentList querySolr(Searching searching) throws SolrServerException, IOException {
        //todo: put keywords to query
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.setSort("id", SolrQuery.ORDER.desc);

        QueryResponse queryResponse = solr.query(query);
        SolrDocumentList solrDocuments = queryResponse.getResults();

        return solrDocuments;
    }
}
