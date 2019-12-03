package com.mycompany.lab5;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.store.SimpleFSDirectory;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.nio.file.Paths;

public class main {
    private static void addDoc(IndexWriter w, String description, String name, String category, int id, float price)
            throws IOException {
        Document doc = new Document();
        //doc.add(new TextField("title", title, Field.Store.YES));
        //doc.add(new StringField("isbn", isbn, Field.Store.YES));
        doc.add(new TextField("description", description, Field.Store.YES));
        doc.add(new TextField("name", name, Field.Store.YES));
        doc.add(new TextField("category", category, Field.Store.YES));
        doc.add(new StringField("ID", String.valueOf(id), Field.Store.YES));
        doc.add(new FloatPoint("price", price));
        w.addDocument(doc);
    }
    public static void tutorial() throws IOException, ParseException {
        /*StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory index = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter w = new IndexWriter(index, config);
        addDoc(w, "Lucene in Action", "193398817");
        addDoc(w, "Lucene for Dummies", "55320055Z");
        addDoc(w, "Managing Gigabytes", "55063554A");
        addDoc(w, "The Art of Computer Science", "9900333X");
        w.close();
        String querystr = "Lucene";
        Query q = new QueryParser("title", analyzer).parse(querystr);
        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i+1) + ". " + d.get("isbn") + "\t" + d.get("title"));
        }*/
    }
    public static void main(String[] args) throws IOException, ParseException {

        StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory index = new SimpleFSDirectory(Paths.get("zapis"));
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter w = new IndexWriter(index, config);
        try (ItemProvider provider = new ItemProvider("items.xml")) {
            while (provider.hasNext()) {
                Item item = provider.next();
                addDoc(w, item.getDescription(), item.getName(), item.getCategory(),item.getId(),item.getPrice());
            }
            w.close();
        } catch (XMLStreamException | IOException ex) {
            ex.printStackTrace();
        }

        Query q = new QueryParser("ID", analyzer).parse("150");
        int hitsPerPage = 10;
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;
        System.out.println("Found " + hits.length + " hits.");
        for (int i = 0; i < hits.length; ++i) {
            int docId = hits[i].doc;
            Document d = searcher.doc(docId);
            System.out.println((i+1) + ". id: " + d.get("ID") + "\t  Nazwa: " + d.get("name")+ "\t  Cena: " + d.get("price")+ "\t  Kategoria: " + d.get("category")+ "\t  Opis: " + d.get("description"));
        }

        System.out.println("Zadanie 2");
        System.out.println("Podpunkt a");
        Query a=new QueryParser("name", analyzer).parse("Obiektyw NOT Sigma");
        int hitsPerPagea=10;
        IndexReader readera= DirectoryReader.open(index);
        IndexSearcher searchera = new IndexSearcher(readera);
        TopDocs docsa = searchera.search(a, hitsPerPagea);
        ScoreDoc[] hitsa = docsa.scoreDocs;
        System.out.println("Found " + hitsa.length + " hits.");
        for (int i = 0; i < hitsa.length; ++i) {
            int docId = hitsa[i].doc;
            Document d = searchera.doc(docId);
            System.out.println((i+1) + ". id: " + d.get("ID") + "\t  Nazwa: " + d.get("name")+ "\t  Cena: " + d.get("price")+ "\t  Kategoria: " + d.get("category")+ "\t  Opis: " + d.get("description"));
        }
        //nie dziala
        System.out.println("Podpunkt b");
        Query b=new QueryParser("name", analyzer).parse("Obiektyw ");
        int hitsPerPageb=10;
        IndexReader readerb= DirectoryReader.open(index);
        IndexSearcher searcherb = new IndexSearcher(readerb);
        TopDocs docsb = searcherb.search(b, hitsPerPageb);
        ScoreDoc[] hitsb = docsb.scoreDocs;
        System.out.println("Found " + hitsb.length + " hits.");
        for (int i = 0; i < hitsb.length; ++i) {
            int docId = hitsb[i].doc;
            Document d = searcherb.doc(docId);
            System.out.println((i+1) + ". id: " + d.get("ID") + "\t  Nazwa: " + d.get("name")+ "\t  Cena: " + d.get("price")+ "\t  Kategoria: " + d.get("category")+ "\t  Opis: " + d.get("description"));
        }

        System.out.println("Podpunkt c");
        Query c=new QueryParser("category", analyzer).parse("Lustrzanki*");
        int hitsPerPagec=10;
        IndexReader readerc= DirectoryReader.open(index);
        IndexSearcher searcherc = new IndexSearcher(readerc);
        TopDocs docsc = searcherc.search(c, hitsPerPagec);
        ScoreDoc[] hitsc = docsc.scoreDocs;
        System.out.println("Found " + hitsc.length + " hits.");
        for (int i = 0; i < hitsc.length; ++i) {
            int docId = hitsc[i].doc;
            Document d = searcherc.doc(docId);
            System.out.println((i+1) + ". id: " + d.get("ID") + "\t  Nazwa: " + d.get("name")+ "\t  Cena: " + d.get("price")+ "\t  Kategoria: " + d.get("category")+ "\t  Opis: " + d.get("description"));
        }

        System.out.println("Podpunkt d");
        Query ddd=new QueryParser("name", analyzer).parse("Lustrzan~");
        int hitsPerPaged=10;
        IndexReader readerd= DirectoryReader.open(index);
        IndexSearcher searcherd = new IndexSearcher(readerd);
        TopDocs docsd = searcherd.search(ddd, hitsPerPaged);
        ScoreDoc[] hitsd = docsd.scoreDocs;
        System.out.println("Found " + hitsd.length + " hits.");
        for (int i = 0; i < hitsd.length; ++i) {
            int docId = hitsd[i].doc;
            Document dd = searcherd.doc(docId);
            System.out.println((i+1) + ". id: " + dd.get("ID") + "\t  Nazwa: " + dd.get("name")+ "\t  Cena: " + dd.get("price")+ "\t  Kategoria: " + dd.get("category")+ "\t  Opis: " + dd.get("description"));
        }
        //nie dziala
        System.out.println("Podpunkt e");
        Query e=new QueryParser("price", new StandardAnalyzer()).parse("["+5+ " TO " +10+"]");
        int hitsPerPagee=10;
        IndexReader readere= DirectoryReader.open(index);
        IndexSearcher searchere = new IndexSearcher(readere);
        TopDocs docse = searchere.search(e, hitsPerPagee);
        ScoreDoc[] hitse = docse.scoreDocs;
        System.out.println("Found " + hitse.length + " hits.");
        for (int i = 0; i < hitse.length; ++i) {
            int docId = hitse[i].doc;
            Document d = searchere.doc(docId);
            System.out.println((i+1) + ". id: " + d.get("ID") + "\t  Nazwa: " + d.get("name")+ "\t  Cena: " + d.get("price")+ "\t  Kategoria: " + d.get("category")+ "\t  Opis: " + d.get("description"));
        }



    }
}