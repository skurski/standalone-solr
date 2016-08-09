package skurski.solr.controller;


import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import skurski.solr.model.Searching;
import skurski.solr.solr.Index;

import java.io.IOException;

@Controller
public class Database {

    @Autowired
    private Index index;

    @RequestMapping("/db")
    public String importDb(Model model) {
        model.addAttribute("message", "Database imported to SOLR indexes.");
        model.addAttribute("searching", new Searching());

        try {
            index.importFullDb();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "search-form";
    }

    @RequestMapping(value="/search", method= RequestMethod.POST)
    public String search(@ModelAttribute Searching searching, Model model) {
        try {
            SolrDocumentList result = index.querySolr(searching);
            model.addAttribute("result", result);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "result";
    }

}
